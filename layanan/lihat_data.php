<?php

	require_once 'setting_server.php';

	$query = "Select * from produk";

	$sql = mysqli_query($con, $query);

	$ray = array();

	while ($row = mysqli_fetch_array($sql)) {
		array_push($ray, array(
			"id_produk" => $row ['id_produk'],
			"nama_produk" => $row ['nama_produk'],
			"kategori_produk" => $row ['kategori_produk'],
			"harga" => $row ['harga'],
			"gambar" => $row ['gambar']
			

			));
	}

	echo json_encode($ray);
	mysqli_close($con);
?>