### QFImage
QFImage产生的初衷是通过制定统一的**标准接口**，减少更换图片加载库的成本。

### 效果图
<img src="https://i.loli.net/2019/03/03/5c7be63fd0604.gif" width="38%" />

### 使用方法

在AndroidManifest中添加权限
```
 <uses-permission android:name="android.permission.INTERNET"/>
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

如果需要加载http图片，还需在Application下添加
```
 android:usesCleartextTraffic="true"
```

#### 从不同途径加载图片
加载一张普通的网络图片非常简单
```
ImageLoader.get().loadImage(imageView, IMG_URL);
```

同时，QFImage也支持从各种不同的途径加载图片
```
//从资源文件加载
ImageLoader.get().loadImage(imageView, R.mipmap.xxx);

//从文件加载
ImageLoader.get().loadImage(imageView, file);

//从uri加载
ImageLoader.get().loadImage(imageView, uri);
```

#### 加载配置
QFImage支持对加载的图片进行各种配置

以典型的圆形图片为例

```
ImageLoader.get().loadImage(imageView, IMG_URL,
                        ImageOptions.option()
                        .circleCrop()
                        .build());
```
进行配置需要构建ImageOptions对象，目前支持的配置有
 - placeholder 占位图
 - error 加载失败显示的图片
 - circleCrop 圆形裁剪
 - centerCrop 中心裁剪
 - roundCorner 圆角
 - override 自定义加载图片的宽高

### 全局配置
全局配置需要在应用程序入口处设置，如Application的onCreate()方法中。
#### 自定义图片加载策略
可以通过设置图片加载策略，一键修改图片加载使用的框架。
```
ImageLoader.get().setImageLoaderStrategy(GlideImageLoaderStrategy())

```
目前仅支持GlideImageLoaderStrategy

#### 自定义磁盘缓存大小
QFImage支持自定义图片磁盘缓存大小
```
ImageLoader.get().setDiskCacheSize(100*1024*1024);
```

### TODO List
 - 支持配置加载成功和失败的回调
 - 支持自定义圆角的每个角的大小
 - ...
