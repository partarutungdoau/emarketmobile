<?php

	require_once '../setting_server.php';

	$query = "Select * from produk ";
	// $upload_path = "../PhotoUploads/Uploads/$gambar.jpg";
	// $path = "Uploads/$image.jpg";
	// $actualpath = "http://localhost/PhotoUploads/$path";


	$sql = mysqli_query($con, $query);

	$ray = array();

	while ($row = mysqli_fetch_array($sql)) {
		array_push($ray, array(
			"id_produk" => $row ['id_produk'],
			"nama_produk" => $row ['nama_produk'],
			"kategori_produk" => $row ['kategori_produk'],
			"harga" => $row ['harga'],
			"stok_produk" => $row ['stok_produk'],
			"gambar" => $row ['gambar']
			

			));
	}

	echo json_encode($ray);
	mysqli_close($con);
?>