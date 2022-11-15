package tn.esprit.mramaapp.ouvrierActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.mapsforge.core.model.BoundingBox;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.modules.OfflineTileProvider;
import org.osmdroid.tileprovider.util.SimpleRegisterReceiver;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import tn.esprit.mramaapp.R;

public class Map extends AppCompatActivity {
MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

    }

    protected void createMap() {
        //Options de la carte
        mapView = (MapView)findViewById(R.id.mapViewOSM);
        mapView.setUseDataConnection(false);
        mapView.setBuiltInZoomControls(true);
        mapView.setMaxZoomLevel(19D);
        mapView.setMinZoomLevel(16D);

        //Charge la carte depuis les assets
        File file = null;
        try {
            file = getFileFromAssets("mapTest.mbtiles");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.exists()) {
            File[] fileTab = new File[1];
            fileTab[0] = file;
            OfflineTileProvider tileProvider = null;
            try {
                tileProvider = new OfflineTileProvider(new SimpleRegisterReceiver(this), fileTab);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mapView.setTileProvider(tileProvider);
            GeoPoint mapCenter = (GeoPoint) mapView.getProjection().fromPixels(
                    mapView.getWidth()/2,
                    mapView.getHeight()/2);

            //Place la position de la carte
            IMapController mapController = mapView.getController();
            mapController.setZoom(18D);
            mapController.setCenter(mapCenter);
            //mapView.setScrollableAreaLimit(new BoundingBox(-1, 411, 3, 1000));
            mapView.scrollTo(-1,411);
        }
    }

    public File getFileFromAssets(String aFileName) throws IOException {
        File cacheFile = new File(this.getCacheDir(), aFileName);
        try {
            InputStream inputStream = this.getAssets().open(aFileName);
            try {
                FileOutputStream outputStream = new FileOutputStream(cacheFile);
                try {
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buf)) > 0) {
                        outputStream.write(buf, 0, len);
                    }
                } finally {
                    outputStream.close();
                }
            } finally {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new IOException("Could not open "+aFileName, e);
        }
        return cacheFile;
    }



}