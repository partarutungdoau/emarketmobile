<h2>Pelanggan</h2>
<div class="x_content">
    <table class="table table-striped projects">
        <thead>
            <tr>
                <th style="width: 1%">#</th>
                <th style="width: 20%">Nama Lengkap</th>
                <th>Alamat</th>
                 <th>Email</th>
                <th>No. Telepon</th>
                <th style="width: 20%">Aksi</th>
            </tr>
        </thead>
        <tbody>
        <?php $nomor=1; ?>
        <?php $get=$connect->query("SELECT * FROM user where role ='Pembeli' "); ?>
        <?php while($pecah = $get->fetch_assoc()){ ?>
            <tr>
                <td><?php echo $nomor; ?></td>
                <td>
                    <?php echo $pecah['nama']; ?>
                </td>
                <td>
                	<?php echo $pecah['alamat']; ?>
                </td>
                <td>
                    <?php echo $pecah['email']; ?>
                </td>
                 <td>
                    <?php echo $pecah['no_telepon']; ?>
                </td>
                <td>
                   <a href="index.php?halaman=detail_customer&id=<?php echo $pecah['id_user']; ?>" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                    <a href="#" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                    <a href="index.php?halaman=hapus_customer&id=<?php echo $pecah['id_user']; ?>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                </td>
            </tr>      
            <?php $nomor++;?>
            <?php } ?>
        </tbody>
    </table>
    <a href="#" class="btn btn-success btn-xs"><i class="fa fa-folder"></i>Tambah Pelanggan</a>
    <!-- end project list -->

</div>