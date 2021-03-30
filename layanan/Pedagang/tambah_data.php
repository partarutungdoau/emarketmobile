<?php

	// session_start();
	// 	 // jika belum ada sesion pelanggan(belum login)maka dilarikan ke login.php
	// 	    if (!isset($_SESSION["user"])) 
	// 	    {
	// 	    	// echo "<script>alert('anda harus loginterlebih dahulu');</script>";
	// 	    	echo "<script>location='../login.php';</script>";
	// 	    }
	
	if($_SERVER['REQUEST_METHOD']=='POST'){
		// $id_mhs = $_POST['id_mhs'];
		//$id_pedagang = $_SESSION["user"]["id_user"];
		$nama_produk = $_POST['nama_produk'];
		$kategori_produk = $_POST ['kategori_produk'];
		$harga = $_POST ['harga'];
		$stok_produk = $_POST ['stok_produk'];
		$gambar = $_POST ['gambar'];

		$image = $_POST ['image'];
		$upload_path = "../PhotoUploads/Uploads/$gambar.jpg";

	require_once ('../setting_server.php');

	// $path = "Uploads/$image.jpg";
	// $actualpath = "http://localhost/PhotoUploads/$path"; 

		$sql ="INSERT INTO produk (nama_produk, kategori_produk, harga, stok_produk, gambar) VALUES ('$nama_produk', '$kategori_produk', '$harga','$stok_produk','$upload_path')";
		if(mysqli_query($con,$sql)){
			file_put_contents($upload_path, base64_decode($image));

			echo json_encode(array('response'=>"Image upload suscess"));

			echo "Berhasil";

		}else
		echo "gagal";
	}

	?>