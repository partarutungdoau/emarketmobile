<h1>Selamat Datang Administrator Par33</h1>
<?php
	// print_r($_SESSION['administrator']);

	if (!isset($_SESSION['administrator'])){
        echo "<script>alert('Anda Harus Login ')</script>";
        echo "<script>location='login.php'</script>";
        header('location:login.php');
        exit();
    }
?>
