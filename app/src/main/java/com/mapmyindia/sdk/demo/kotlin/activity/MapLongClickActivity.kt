package com.mapmyindia.sdk.demo.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapmyindia.sdk.demo.R

/**
 * Created by CEINFO on 26-02-2019.
 */
class MapLongClickActivity : AppCompatActivity(), OnMapReadyCallback {
    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)
        mapView = findViewById(R.id.map_view)
        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync(this)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        mapboxMap.cameraPosition = setCameraAndTilt()

        mapboxMap.setMinZoomPreference(4.5)
        mapboxMap.setMaxZoomPreference(18.5)
        mapboxMap.setPadding(20, 20, 20, 20)
        mapboxMap.addOnMapLongClickListener { latLng -> Toast.makeText(this@MapLongClickActivity, latLng.toString(), Toast.LENGTH_LONG).show() }
    }

    protected fun setCameraAndTilt(): CameraPosition {
        return CameraPosition.Builder().target(LatLng(
                28.551087, 77.257373)).zoom(14.0).tilt(0.0).build()
    }

    override fun onMapError(i: Int, s: String) {

    }

    override fun onStart() {
        super.onStart()
        mapView!!.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView!!.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView!!.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        mapView!!.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView!!.onResume()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView!!.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView!!.onSaveInstanceState(outState)
    }
}