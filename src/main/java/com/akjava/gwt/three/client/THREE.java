/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client;

import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Color;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vertex;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.materials.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.materials.MeshLambertMaterialBuilder;
import com.akjava.gwt.three.client.materials.ParticleBasicMaterialBuilder;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.objects.Particle;
import com.akjava.gwt.three.client.objects.ParticleSystem;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JsArray;





public class THREE {

	public static  native final JSONLoader JSONLoader()/*-{
	return  new $wnd.THREE.JSONLoader();
	}-*/;

	

	
	
	public static native final Camera PerspectiveCamera(int fieldOfView,double ratio,double near,double far)/*-{
	return new $wnd.THREE.PerspectiveCamera( fieldOfView, ratio, near, far ); 
	}-*/;
	
	
	
	public static native final Scene Scene()/*-{
	return new $wnd.THREE.Scene();
	}-*/;
	
	public static native final Light AmbientLight(int color)/*-{
	return new $wnd.THREE.AmbientLight(color);
	}-*/;
	
	
	public static  final Geometry Cube(double x,double y,double z,int xpart,int ypart,int zpart,Material[] material ){
		JsArray<Material> arrays=(JsArray<Material>) JsArray.createArray();
		for(Material m:material){
			arrays.push(m);
		}
		
		return Cube(x,y,z,xpart,ypart,zpart,arrays);
	}
	
	//I'm happy to fix array problem.
	public static native final Geometry Cube(double x,double y,double z,int xpart,int ypart,int zpart,JsArray<Material> materials)/*-{
	
	material = new $wnd.THREE.MeshBasicMaterial({color: 0xff0000, wireframe: false});
    var ms=new $wnd.Array();
    for (var i = 0; i < materials.length; i++) {
		ms.push(materials[i]);
        }
        
	return new $wnd.THREE.CubeGeometry( x, y, z ,xpart,ypart,zpart,ms);
	}-*/;
	
	
	
	public static native final Geometry Geometry()/*-{
	return new $wnd.THREE.Geometry();
	}-*/;
	
	public static native final Object3D Object3D()/*-{
	return new $wnd.THREE.Object3D();
	}-*/;
	
	public static native final Geometry CubeGeometry(double x,double y,double z)/*-{
	return new $wnd.THREE.CubeGeometry( x, y, z );
	}-*/;
	
	public static native final Geometry PlaneGeometry(double x,double y)/*-{
	return new $wnd.THREE.PlaneGeometry( x, y );
	}-*/;
	public static native final Geometry SphereGeometry(double radius ,int segments,int rings)/*-{
	return new $wnd.THREE.SphereGeometry( radius, segments, rings );
	}-*/;
	
	public static native final Geometry CylinderGeometry(double topRad,double botRad,double height,int radSegs)/*-{
	return new $wnd.THREE.CylinderGeometry( topRad,botRad,height,radSegs );
	}-*/;
	
	public static  final MeshBasicMaterialBuilder MeshBasicMaterial(){
		return MeshBasicMaterialBuilder.create();
	}
	public static  final MeshLambertMaterialBuilder MeshLambertMaterial(){
		return MeshLambertMaterialBuilder.create();
	}
	public static  final ParticleBasicMaterialBuilder ParticleBasicMaterial(){
		return ParticleBasicMaterialBuilder.create();
	}
	
	/**
	 * @param color
     * @param wireFrame
     * @deprecated
     * @return
	 */
	public static native final Material MeshLambertMaterial(int color,boolean wireFrame)/*-{
	return new $wnd.THREE.MeshLambertMaterial( { color: color, wireframe: wireFrame } );
	}-*/;
	
	/**
	 * @deprecated
	 * use builder
	 * @param color
	 * @param wireFrame
	 * @return
	 */
	public static native final Material MeshBasicMaterial(int color,boolean wireFrame)/*-{
	return new $wnd.THREE.MeshBasicMaterial( { color: color, wireframe: wireFrame } );
	}-*/;
	public static native final Material MeshFaceMaterial()/*-{
	return new $wnd.THREE.MeshFaceMaterial();
	}-*/;
	
	public static native final Vertex Vertex(Vector3 vector3f )/*-{
	return new $wnd.THREE.Vertex( vector3f);
	}-*/;
	
	public static native final Vector3 Vector3(double x,double y,double z)/*-{
	return new $wnd.THREE.Vector3( x,y,z);
	}-*/;
	
	
	
	public static native final Particle Particle(Material material )/*-{
	return new $wnd.THREE.Particle(material );
	}-*/;

	public static native final ParticleSystem ParticleSystem(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.ParticleSystem( geometry, material );
	}-*/;
	
	public static native final Mesh Mesh(Geometry geometry,Material material )/*-{
	return new $wnd.THREE.Mesh( geometry, material );
	}-*/;
	
	
	public static native final Color Color(int hex)/*-{
	return new $wnd.THREE.Color(hex);
	}-*/;
	
	public static native final WebGLRenderer WebGLRenderer()/*-{
	return new $wnd.THREE.WebGLRenderer();
	}-*/;
	
	public static native final Light PointLight(int color)/*-{
	return new $wnd.THREE.PointLight(color);
	}-*/;
	public static native final Light SpotLight(int color)/*-{
	return new $wnd.THREE.SpotLight(color);
	}-*/;
	public static native final Projector Projector()/*-{
	return new $wnd.THREE.Projector();
	}-*/;

    enum Mapping{
      UVMapping                   ,
      LatitudeReflectionMapping   ,
      CubeReflectionMapping       ,
      SphericalReflectionMapping  ,
    }
	public enum Blending{
	 NormalBlending               ,
	 AdditiveBlending             ,
	 SubtractiveBlending          ,
	 MultiplyBlending             ,
	 AdditiveAlphaBlending        ,
    }
}
