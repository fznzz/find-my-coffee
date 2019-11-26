package ugm.fznzz.findmycoffee.Adapter;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import ugm.fznzz.findmycoffee.Activity.MainMenu;
import ugm.fznzz.findmycoffee.DataClass.ItemMenu;
import ugm.fznzz.findmycoffee.DataClass.Shop;
import ugm.fznzz.findmycoffee.Fragment.HomeFragment;
import ugm.fznzz.findmycoffee.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<ItemMenu> itemMenuList;
    List<Shop> shopList;
    Dialog mDialog;

//    Dialog mDialog;


    public RecyclerViewAdapter(Context mContext, List<ItemMenu> itemMenuList, List<Shop> shopList) {
        this.mContext = mContext;
        this.itemMenuList = itemMenuList;
        this.shopList = shopList;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        ItemMenu data = itemMenuList.get(position);
        holder.storename.setText(data.getShopName());
        holder.address.setText(data.getAddress());

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        final MyViewHolder vholder = new MyViewHolder(v);

//        mDialog = new Dialog(mContext);
//        mDialog.setContentView(R.layout.details_demo);
//        TextView tvName = mDialog.findViewById(R.id.tv2cshopname);
//        TextView tvAddress = mDialog.findViewById(R.id.tv2address);
//        TextView tvOpenHours = mDialog.findViewById(R.id.tv2openhours);
//        TextView tvPriceRange = mDialog.findViewById(R.id.tv2pricerange);
//        Button btopenlink = mDialog.findViewById(R.id.buttonLink);
//        tvName.setText(shopList.get(vholder.getAdapterPosition()).getShopName());
//        tvAddress.setText(shopList.get(vholder.getAdapterPosition()).getAddress());
//        tvOpenHours.setText(shopList.get(vholder.getAdapterPosition()).getOpenHours());
//        tvPriceRange.setText(shopList.get(vholder.getAdapterPosition()).getPriceRange());
//        btopenlink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToUrl(shopList.get(vholder.getAdapterPosition()).getLink());
//            }
//        });

        vholder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Testclick " + vholder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        return vholder;
    }

    @Override
    public int getItemCount() {
        return itemMenuList.size();
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        mContext.startActivity(launchBrowser);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView storename;
        TextView address;
        ConstraintLayout item_contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            storename = itemView.findViewById(R.id.tv1storename);
            address = itemView.findViewById(R.id.tv1address);

            item_contact = itemView.findViewById(R.id.contact_item_id);
        }


    }
}
