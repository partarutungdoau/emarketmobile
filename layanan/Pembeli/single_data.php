 <?php

 	$id_mhs = $_GET["id_mhs"];
	require_once 'setting_server.php';

	$query = "Select * from layanan where id=$id_mhs";

	$sql = mysqli_query($con, $query);

	$ray = array();

	while ($row = mysqli_fetch_array($sql)) {
		array_push($ray, array(
			"id_mhs" => $row ['id'],
			"nama_mhs" => $row ['nama'],
			"kelas_mhs" => $row ['kelas']
			

			));
	}

	echo json_encode($ray);
	mysqli_close($con);
?>