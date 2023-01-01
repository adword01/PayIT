package com.example.payit.ui;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.payit.R;

import java.io.IOException;

public class QrScanner extends AppCompatActivity {
    private Camera camera;
    private SurfaceView cameraPreview;
    Button btn_scan;
    public static TextView scantext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);

        scantext= findViewById(R.id.scantext);
        btn_scan= findViewById(R.id.btn_scan);

        btn_scan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), ScannerView.class));
            }
        });


        cameraPreview = findViewById(R.id.camera_preview);

        // Initialize the camera and set it as the preview for the SurfaceView
        camera = getCameraInstance();
        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                // Nothing to do here
                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // Nothing to do here
                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * A safe way to get an instance of the camera object.
     */
    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    }


//        btn_scan=findViewById(R.id.btn_scan);
//        btn_scan.setOnClickListener(v->{
//            scanCode();
//        });
//    }
//    private void scanCode()
//    {
//        ScanOptions options=new ScanOptions();
//        options.setPrompt("Volume up to flash on");
//        options.setBeepEnabled(true);
//        options.setOrientationLocked(true);
//        options.setCaptureActivity(CaptureAct.class);
//        barLauncher.launch(options);
//
//    }
//
//    ActivityResultLauncher<ScanOptions> barLauncher=registerForActivityResult(new ScanContract(), result ->
//    {
//       if(result.getContents()!=null){
//           AlertDialog.Builder builder=new AlertDialog.Builder(QrScanner.this);
//           builder.setTitle("Result");
//           builder.setMessage(result.getContents());
//           builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//               @Override
//               public void onClick(DialogInterface dialogInterface, int i) {
//                   dialogInterface.dismiss();
//               }
//           }).show();
//       }
//    });
//}
