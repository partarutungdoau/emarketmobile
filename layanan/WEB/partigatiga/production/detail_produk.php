<?php
    include 'connect.php';

    $produk_id = $_GET["id"];
    $get = $connect->query("SELECT * FROM produk WHERE id_produk ='$produk_id'");
    $detail_produk =$get->fetch_assoc();
?>

<div class="x_content" role="main">
    <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Detail Produk</h3>
                        </div>
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2><?php echo $detail_produk['nama_produk']; ?></h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">

                                    <div class="col-md-7 col-sm-7 col-xs-12">
                                        <div class="product-image">
                                            <img src="../../../PhotoUploads/Uploads/<?php echo $detail_produk['gambar']; ?>" alt="..."/>
                                        </div>
                                        
                                    </div>

                                    <div class="col-md-5 col-sm-5 col-xs-12" style="border:0px solid #e5e5e5;">

                                        <h3 class="prod_title"><?php echo $detail_produk['nama_produk']; ?></h3>


                                        <div class="">
                                            <h2>Stok : </h2>
                                            <h3> <?php echo $detail_produk['stok_produk']; ?></h3>
                                        </div>
                                        <br />

                                        <div class="">
                                            <h2>Penjual</h2>
                                            <h3></h3>
                                        </div>
                                        <br />

                                        <div class="">
                                            <div class="product_price">
                                                <h1 class="price">Rp. <?php echo $detail_produk['harga']; ?></h1>
                                                <br>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
</div>