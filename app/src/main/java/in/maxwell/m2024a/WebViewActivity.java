package in.maxwell.m2024a;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.wvHtmlData);

        String htmlData = "<html><body><h1>Hello World</h1> <p>fadjfldasjflkjadlkfjadkljflakdjf" +
                "adsfadsfasfadfadsfadFADGFMKJDSFGSK;DGKJSDKGJSKDFGLSFHLGHSG" +
                "DFGSLDFGLSFHAGISJFK;Gs;kjg;sJG;SF;KGJS;JG;KSFGKJSAFGSDFG" +
                "SDgSADGsgsdGwsgWSFDGsgSFG</p> </body></html>";
        webView.getSettings().setJavaScriptEnabled(false);
        webView.loadData(htmlData, "text/html", "UTF-8");

    }
}