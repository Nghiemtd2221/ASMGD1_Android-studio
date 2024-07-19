package fpoly.nghiemtdph44856.asm1_ph44856_restapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {

    List<Carmodel> CarmodelList;
    Context context;
    public CarAdapter (Context context, List<Carmodel> CarmodelList){
        this.CarmodelList=CarmodelList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return CarmodelList.size();
    }

    @Override
    public Object getItem(int position) {
        return CarmodelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_car, parent, false);

        TextView tvID = (TextView) rowView.findViewById(R.id.tvId);
        ImageView imgAvatar = (ImageView) rowView.findViewById(R.id.imgAvatatr);
        TextView tvName = (TextView) rowView.findViewById(R.id.tvName);

        TextView tvNamSX = (TextView) rowView.findViewById(R.id.tvNamSX);

        TextView tvHang = (TextView) rowView.findViewById(R.id.tvHang);

        TextView tvGia = (TextView) rowView.findViewById(R.id.tvGia);

//        String imageUrl = mList.get(position).getThumbnailUrl();
//        Picasso.get().load(imageUrl).into(imgAvatar);
////        imgAvatar.setImageResource(imageId[position]);
        tvName.setText(String.valueOf(CarmodelList.get(position).getTen()));

        tvNamSX.setText(String.valueOf(CarmodelList.get(position).getNamSX()));

        tvHang.setText(String.valueOf(CarmodelList.get(position).getHang()));

        tvGia.setText(String.valueOf(CarmodelList.get(position).getGia()));

        return rowView;
    }
}
