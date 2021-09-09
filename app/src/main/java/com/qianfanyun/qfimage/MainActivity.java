package com.qianfanyun.qfimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.util.Util;
import com.qianfan.qfimage.ImageOptions;
import com.qianfan.qfimage.QfImage;
import com.qianfanyun.qfui.rlayout.RImageView;

public class MainActivity extends AppCompatActivity {

    private static final String IMG_URL = "https://wx4.sinaimg.cn/mw690/b5ff8eb1ly1fzr5yfkup4j22801o0kjo.jpg";

    private static final String GIF_URL = "http://img.soogif.com/N7hsLdFbeo2WhsMS2dFOL1BABabrvi7z.gif_s400x0";

    private RecyclerView recyclerView;

    private ImageView imvBanner;

    private GridLayoutManager gridLayoutManager;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QfImage.INSTANCE.init(this);
        recyclerView = findViewById(R.id.recyclerView);
        imvBanner = findViewById(R.id.banner);

        gridLayoutManager = new GridLayoutManager(this, 3);
        adapter = new MyAdapter();
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new ItemDivider());
        QfImage.INSTANCE.setDiskCacheSize(100 * 1024 * 1024);

        //https://img0.baidu.com/it/u=4280883260,2294162798&fm=26&fmt=auto&gp=0.jpg
        //https://s3.bmp.ovh/imgs/2021/09/f6dbb2911bc1a68f.jpg
        QfImage.INSTANCE.loadImage(imvBanner, "https://img0.baidu.com/it/u=4280883260,2294162798&fm=26&fmt=auto&gp=0.jpg"
                , ImageOptions.Companion
                        .placeholder(R.color.color_c3c3c3)
                        .error(R.color.color_c3c3c3)
                        .centerCrop()
                        .build());
    }

    private class MyAdapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder holder = (MyViewHolder) viewHolder;
            RImageView imageView = holder.imageView;
            TextView textView = holder.textView;

            if (i == 0) {
                QfImage.INSTANCE.loadImage(imageView, IMG_URL);
                textView.setText("加载普通网络图片");
            } else if (i == 1) {
                QfImage.INSTANCE.loadImage(imageView, IMG_URL,
                        ImageOptions.Companion.option()
                                .circleCrop()
                                .build());
                textView.setText("circle裁剪图片");
            } else if (i == 2) {
                QfImage.INSTANCE.loadImage(imageView, IMG_URL, ImageOptions.Companion
                        .placeholder(R.color.colorAccent)
                        .error(R.color.colorAccent)
                        .centerCrop().build());
                textView.setText("centerCrop裁剪");
            } else if (i == 3) {
                QfImage.INSTANCE.loadImage(imageView, GIF_URL);
                textView.setText("加载GIF");
            } else if (i == 4) {
                imageView.getHelper().setCorner(dp2px(MainActivity.this,8));
                QfImage.INSTANCE.loadImage(imageView, GIF_URL, ImageOptions.Companion
                        .placeholder(R.color.colorAccent)
                        .error(R.color.colorAccent)
                        .centerCrop()
                        .build());
                textView.setText("加载圆角图片");
            } else if (i == 5) {
                QfImage.INSTANCE.loadImage(imageView, R.mipmap.meizi);
                textView.setText("加载资源文件图片");
            } else if (i == 6) {
                QfImage.INSTANCE.loadImage(imageView, R.mipmap.meizi, ImageOptions.Companion.override(100, 100).build());
                textView.setText("自定义加载宽高");
            } else if (i == 7) {

            }


        }

        @Override
        public int getItemCount() {
            return 7;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private RImageView imageView;
            private TextView textView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
    }

    class ItemDivider extends RecyclerView.ItemDecoration {

        private Paint paint;

        private int itemHeight;


        public ItemDivider() {
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.parseColor("#E5E5E5"));
            itemHeight = 3;
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);
            for (int i = 0; i < parent.getChildCount(); i++) {
                View view = parent.getChildAt(i);
                c.drawRect(view.getLeft(), view.getBottom() - itemHeight, view.getRight(), view.getBottom(), paint);
                c.drawRect(view.getRight() - itemHeight, view.getTop(), view.getRight(), view.getBottom(), paint);
            }
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
        }

    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
