<?
    include "connect.php";
?>

<div class="x_content">
    <form method="POST" class="form-horizontal form-label-left" enctype="multipart/form-data">
        <span class="section">Tambah Produk</span>

        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Nama Produk <span>*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input id="nama_produk" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="nama_produk" required type="text">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Deskripsi <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <textarea id="textarea" required="required" name="deskripsi" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Harga <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="number" id="harga" name="harga" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Stok <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="number" id="stok" name="stok" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Gambar <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="file" id="file" name="gambar" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        
        <div class="ln_solid"></div>
        <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
                <a href="index.php?halaman=produk" class="btn btn-primary">Batal</a>
                <button class="btn btn-success" name="tambah_produk">Tambah</button>
            </div>
        </div>
    </form>
    <?php
        if (isset($_POST["tambah_produk"]))
        {
            //mengambil nilai
            $nama_gambar = $_FILES['gambar']['name'];
            $lokasi = $_FILES['gambar']['tmp_name'];
            move_uploaded_file($lokasi,"images/".$nama_gambar);
            
            	//var_dump($_POST);
            

            //query insert kedalam tabel
            // $get = $connect->query("SELECT * FROM produk WHERE e_mail = '$e_mail'");
            // $yangcocok = $get->num_rows;
            // var_dump($yangcocok);
            
	            $connect ->query("INSERT INTO produk (nama_produk,deskripsi,gambar,harga,stok) VALUES ('$_POST[nama_produk]', '$_POST[deskripsi]', '$nama_gambar', '$_POST[harga]', '$_POST[stok]')");
	            echo "<script> alert('Berhasil Menambah Produk);</script>";
	            echo "<script> location='index.php?halaman=produk'</script>";
        }
    ?>

</div>