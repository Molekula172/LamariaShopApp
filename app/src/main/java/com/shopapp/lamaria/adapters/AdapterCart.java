package com.shopapp.lamaria.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopapp.lamaria.Config;
import com.shopapp.lamaria.R;
import com.shopapp.lamaria.activities.ActivityCart;
import com.shopapp.lamaria.models.Cart;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;
import java.util.Locale;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ViewHolder> {

    private Context context;
    private List<Cart> arrayCart;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView product_name;
        TextView product_quantity;
        TextView product_price;
        ImageView product_image;

        public ViewHolder(View view) {
            super(view);
            product_name = view.findViewById(R.id.product_name);
            product_quantity = view.findViewById(R.id.quantity);
            product_price = view.findViewById(R.id.product_price);
            product_image = view.findViewById(R.id.product_image);
        }

    }

    public AdapterCart(Context context, List<Cart> arrayCart) {
        this.context = context;
        this.arrayCart = arrayCart;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.product_name.setText(ActivityCart.product_name.get(position));

        if (Config.ENABLE_DECIMAL_ROUNDING) {




            String price = String.format(Locale.GERMAN, "%1$,.0f", ActivityCart.sub_total_price.get(position));
            holder.product_price.setText(price + " " + ActivityCart.currency_code.get(position));
        } else {




            holder.product_price.setText(ActivityCart.sub_total_price.get(position) + " " + ActivityCart.currency_code.get(position));
        }

        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(8)
                .oval(false)
                .build();

        Picasso.with(context)
                .load(Config.ADMIN_PANEL_URL + "/upload/product/" + ActivityCart.product_image.get(position))
                .placeholder(R.drawable.ic_loading)
                .resize(250, 250)
                .centerCrop()
                .transform(transformation)
                .into(holder.product_image);

        holder.product_quantity.setText(ActivityCart.product_quantity.get(position) + " шт.");

    }

    @Override
    public int getItemCount() {
        return ActivityCart.product_id.size();
    }

}
