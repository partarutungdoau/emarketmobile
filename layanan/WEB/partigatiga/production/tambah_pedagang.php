<?
    include "connect.php";
?>

<div class="x_content">
    <form method="POST" class="form-horizontal form-label-left" enctype="multipart/form-data">
        <span class="section">Tambah Pedagang</span>

        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Nama Lengkap <span>*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input id="nama_lengkap" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="nama_lengkap" required type="text">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Jenis Kelamin <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <select id="jenis_kelamin" name="jenis_kelamin" required="" class="form-control col-md-7 col-xs-12">
                    <option></option>
                    <option>Laki-laki</option>
                    <option>Perempuan</option>
                </select>
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">No. Telepon <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="number" id="no_telp" name="no_telp" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Email <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="email" id="email" name="e_mail" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Username <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="username" name="username" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Password <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="password" name="password" required="required" class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">Alamat Lengkap <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <textarea id="textarea" required="required" name="alamat" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
        </div>
        <div class="ln_solid"></div>
        <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
                <a href="index.php?halaman=pedagang" class="btn btn-primary">Batal</a>
                <button class="btn btn-success" name="tambah_pedagang">Tambah</button>
            </div>
        </div>
    </form>
    <?php
        if (isset($_POST["tambah_pedagang"]))
        {
            //mengambil nilai
            $nama_lengkap = $_POST["nama_lengkap"];
            $jenis_kelamin = $_POST["jenis_kelamin"];
            $no_telp = $_POST["no_telp"];
            $e_mail = $_POST["e_mail"];
            $username = $_POST["username"];
            $password = $_POST["password"];
            $alamat = $_POST["alamat"];

            //query insert kedalam tabel
            $get = $connect->query("SELECT * FROM seller WHERE e_mail = '$e_mail'");
            $yangcocok = $get->num_rows;
            var_dump($yangcocok);
            if($yangcocok == 1){
                echo "<script> alert('Gagal Ditambah, Email sudah digunakan');</script>";
                echo "<script> location='index.php?halaman=tambah_pedagang'</script>";
            }else{
                //koneksi ke tabel seller
                $connect ->query("INSERT INTO seller (nama_lengkap,jenis_kelamin,no_telp,e_mail,username,password,alamat) VALUES ('$nama_lengkap', '$jenis_kelamin', '$no_telp', '$e_mail', '$username', '$password', '$alamat')");
                echo "<script> alert('Berhasil Menambah Pedagang);</script>";
                echo "<script> location='index.php?halaman=pedagang'</script>";
            }
        }
    ?>

</div>