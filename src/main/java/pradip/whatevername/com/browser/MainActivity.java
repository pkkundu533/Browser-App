package pradip.whatevername.com.browser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private Button btnnext,btnBack,btnHistory,btnRefresh;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnnext=findViewById(R.id.next);
        btnBack=findViewById(R.id.back);
        btnHistory=findViewById(R.id.history);
        btnRefresh=findViewById(R.id.refresh);

        webView=findViewById(R.id.webView);



        webView.setWebViewClient(new OurViewClient());

        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        try
        {
            webView.loadUrl("https://www.google.com");
        }catch (Exception e)
        {
            Toast.makeText(this,"Error occure", Toast.LENGTH_SHORT).show();
        }

        btnRefresh.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnnext.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.next:

                if(webView.canGoForward())
                {
                    webView.goForward();
                }

                break;
            case R.id.back:

                if(webView.canGoBack())
                {
                    webView.goBack();
                }
                break;
            case R.id.history:
                webView.clearHistory();
                break;
            case R.id.refresh:
                webView.reload();
                break;
        }
    }
}
