<h2>Prdouk</h2>
<div class="x_content">
    <table class="table table-striped projects">
        <thead>
            <tr>
                <th style="width: 1%">#</th>
                <th style="width: 20%">Nama Produk</th>
                <th>Deskripsi</th>
                <th>Harga</th>
                <th style="width: 20%">Aksi</th>
            </tr>
        </thead>
        <tbody>
        <?php $nomor=1; ?>
        <?php $get=$connect->query("SELECT * FROM produk"); ?>
        <?php while($pecah = $get->fetch_assoc()){ ?>
            <tr>
                <td><?php echo $nomor; ?></td>
                <td>
                    <?php echo $pecah['nama_produk']; ?>
                </td>
                <td>
                    <?php echo $pecah['stok_produk']; ?>
                </td>
                <td class="project_progress">
                    <?php echo $pecah['harga']; ?>
                </td>
                <td>
                    <a href="index.php?halaman=detail_produk&id=<?php echo $pecah['id_produk']; ?>" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                    <a href="#" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                    <a href="index.php?halaman=hapus_produk&id=<?php echo $pecah['id_produk']; ?>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                </td>
            </tr>      
            <?php $nomor++;?>
            <?php } ?>
        </tbody>
    </table>
    <a href="index.php?halaman=tambah_produk" class="btn btn-success btn-xs"><i class="fa fa-folder"></i>Tambah Produk</a>
    <!-- end project list -->

</div>