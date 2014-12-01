package cn.edu.gdmec.s07131033.demo_volley;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	/*TextView tv;*/
	private NetworkImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* tv = (TextView) findViewById(R.id.textView1);
        
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest("http://www.baidu.com", new Listener<String>() {

			@Override
			public void onResponse(String response) {
				tv.setText(response);
				
			}
		},new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("error", error.getMessage());
				
			}
		});
        queue.add(request);*/
        
        imageview = (NetworkImageView) findViewById(R.id.imageview);
    }
    
    public void IMAGE(View v) {
    	String url = new String("http://e.hiphotos.baidu.com/image/pic/item/ac4bd11373f082026ea01c3548fbfbedab641b8d.jpg");
		RequestQueue queue = Volley.newRequestQueue(this);
		final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(10);
		ImageCache imageCache = new ImageCache() {
			
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				lruCache.put(url, bitmap);
				
			}
			
			@Override
			public Bitmap getBitmap(String url) {
				// TODO Auto-generated method stub
				return lruCache.get(url);
			}
		};
		
		ImageLoader imageLoader = new ImageLoader(queue, imageCache);
		imageview.setImageUrl(url, imageLoader);

	}
}
