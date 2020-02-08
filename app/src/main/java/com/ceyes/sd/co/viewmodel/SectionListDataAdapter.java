package com.ceyes.sd.co.viewmodel;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */




import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static java.security.AccessController.getContext;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;
    URL url = null;
    int click=0;
    int row_index=-1;
    private static final float BLUR_RADIUS = 25f;
    Uri imageuri1;
  //  public Activity mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, final int i) {

        final SingleItemModel singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.getName());
        holder.tvTitle2.setText(singleItem.getName());
        holder.image.setText(singleItem.getName());
        holder.tvTitle1.setText(singleItem.getName());
        holder.descr.setText(singleItem.getBrand());
        holder.price.setText("\u20B9"+singleItem.getPrice());
        holder.taddress.setText(singleItem.getBrand());
        holder.mapaddress.setText(singleItem.getName());
        holder.t_id.setText(singleItem.getId());
        holder.tname.setText(singleItem.getId());
        holder.area.setText(singleItem.getId());
        //holder.image.setText(singleItem.getName());

      //System.out.println(""+singleItem.getCname().length());
      System.out.println(""+"http://www.maydmedia.in/admin/"+singleItem.getImages());
//        new DownloadImageTask(holder.itemImage)
//                .execute(singleItem.getUrl().replace("https","http"));
//        Picasso.get()
//                .load(singleItem.getUrl().replace("https","http"))
//                .placeholder(R.drawable.logo)
//                .error(R.drawable.logo)
//                .into(holder.itemImage);
        holder.itemImage.invalidate();
        imageuri1 = Uri.parse("http://gupshup.site/apisv1/uploads/"+singleItem.getImages());
        holder.itemImage.setImageURI(imageuri1);
//        Glide.with(mContext).load(singleItem.getUrl().replace("https","http"))
//                //.apply(new BlurTransformation(22))
//                .into(holder.itemImage);

        holder.itemImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=i;
//                if(row_index==i) {
//                    holder.l1.setVisibility(View.VISIBLE);
//                }
//                else
//                {
//                    holder.l1.setVisibility(View.INVISIBLE);
//                }
if(click>1) {
    Toast.makeText(v.getContext(), singleItem.getName(), Toast.LENGTH_SHORT).show();
//    Intent myactivity = new Intent(v.getContext(), Detail.class);
//    myactivity.putExtra("name", singleItem.getName());
//    myactivity.putExtra("address", singleItem.getTaddress());
//    myactivity.putExtra("map", singleItem.getMapaddress());
//    myactivity.putExtra("t_id", singleItem.getT_id());
//    myactivity.putExtra("image", singleItem.getName());
//    myactivity.putExtra("price", singleItem.getPrice());
//    myactivity.putExtra("tname", singleItem.getTname());
//    myactivity.putExtra("area", singleItem.getName());
//    myactivity.putExtra("bookingtable", singleItem.getIsBookingTable());
//    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
//    v.getContext().startActivity(myactivity);
}
else
{

}
                click=click+1;
            }
        });


        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=i;
                notifyDataSetChanged();

               // holder.l1.setVisibility(View.VISIBLE);

                mContext = (Activity) holder.itemView.getContext();
//                    Toast.makeText(v.getContext(), singleItem.getName(), Toast.LENGTH_SHORT).show();
//                    Intent myactivity = new Intent(v.getContext(), Product_sub.class);
//                    myactivity.putExtra("name", singleItem.getUrl());
//                    myactivity.putExtra("id", singleItem.getUrl());
//                    myactivity.putExtra("url","http://gupshup.site/apisv1/uploads/"+singleItem.getCname());
//                    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
//                    v.getContext().startActivity(myactivity);
//                ((Activity) getContext()).overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });


        holder.tvTitle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=i;
                notifyDataSetChanged();

                // holder.l1.setVisibility(View.VISIBLE);


////                    Toast.makeText(v.getContext(), singleItem.getName(), Toast.LENGTH_SHORT).show();
//                Intent myactivity = new Intent(v.getContext(), Detail.class);
//                myactivity.putExtra("name", singleItem.getName());
//                myactivity.putExtra("address", singleItem.getTaddress());
//                myactivity.putExtra("map", singleItem.getMapaddress());
//                myactivity.putExtra("t_id", singleItem.getT_id());
//                myactivity.putExtra("image", singleItem.getName());
//                myactivity.putExtra("price", singleItem.getPrice());
//                myactivity.putExtra("tname", singleItem.getTname());
//                myactivity.putExtra("area", singleItem.getName());
//                myactivity.putExtra("bookingtable", singleItem.getIsBookingTable());
//                myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
//                v.getContext().startActivity(myactivity);
//                ((Activity) getContext()).overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });
//        if(row_index==i) {
//            System.out.println("i is in "+i);
//            holder.itemImage.setImageResource(0);
//            holder.l1.setVisibility(View.VISIBLE);
//            holder.tvTitle2.setVisibility(View.INVISIBLE);
//            try {
//                //  System.out.print(""+singleItem.getUrl().replace("https","http"));
//                //  URL url = new URL(singleItem.getUrl().replace("https","http"));
//                Bitmap image = getBitmapFromURL(singleItem.getUrl().replace("https","http"));
//                Bitmap blurredBitmap = blur(image);
//                holder.itemImage.setImageBitmap(blurredBitmap);
//
//            } catch(Exception e) {
//                System.out.println(e);
//            }
//        }
//        else
//        {
//            //  System.out.println(""+i);
//            holder.tvTitle2.setVisibility(View.VISIBLE);
//            holder.l1.setVisibility(View.INVISIBLE);
//            Glide.with(mContext).load(singleItem.getUrl().replace("https","http"))
//                    //.apply(new BlurTransformation(22))
//                    .into(holder.itemImage);
//        }
   //     Picasso.get().setLoggingEnabled(true);

//        try {
//           URL url1 = new URL(singleItem.getUrl());
//            Bitmap bmp = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
//            holder.itemImage.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Picasso.with(mContext)
//                .load(singleItem.getUrl())
//                .placeholder(R.drawable.logo)// Place holder image from drawable folder
//                .error(R.drawable.logo)
//                .into(holder.itemImage);


    }
    private Context getContext() {
        return mContext;
    }
    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected TextView tvTitle123;
        protected TextView image;
        protected TextView tvTitle1,tvTitle2;
        protected TextView descr;
        protected TextView price;
        protected TextView taddress;
        protected TextView mapaddress;
        protected TextView t_id;
        protected TextView tname;
        protected TextView area;
        protected LinearLayout l1;

        protected SimpleDraweeView itemImage;
        protected SimpleDraweeView itemImage1;


        @SuppressLint("WrongViewCast")
        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
          //  this.tvTitle123 = (TextView) view.findViewById(R.id.tvTitle123);
            this.itemImage = (SimpleDraweeView) view.findViewById(R.id.itemImage);
            this.itemImage1 = (SimpleDraweeView) view.findViewById(R.id.itemImage1);
            this.image = (TextView) view.findViewById(R.id.image);
            this.tvTitle1 = (TextView) view.findViewById(R.id.tvTitle1);
            this.tvTitle2 = (TextView) view.findViewById(R.id.tvTitle2);
            this.descr = (TextView) view.findViewById(R.id.descr);
            this.price = (TextView) view.findViewById(R.id.price);
            this.taddress = (TextView) view.findViewById(R.id.taddress);
            this.mapaddress = (TextView) view.findViewById(R.id.mapaddress);
            this.t_id = (TextView) view.findViewById(R.id.t_id);
            this.tname = (TextView) view.findViewById(R.id.tname);
            this.area = (TextView) view.findViewById(R.id.area);
        //    this.l1 = (LinearLayout) view.findViewById(R.id.l1);





        }

    }
    @SuppressLint("NewApi")
    public Bitmap blur(Bitmap image) {
        if (null == image) return null;
        Bitmap outputBitmap = Bitmap.createBitmap(image);
        final RenderScript renderScript = RenderScript.create(mContext);
        Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);
        //Intrinsic Gausian blur filter
        @SuppressLint({"NewApi", "LocalSuppress"})
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}