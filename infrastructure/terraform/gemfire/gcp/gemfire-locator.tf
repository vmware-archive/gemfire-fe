resource "google_compute_instance" "gemfire_locator" {

  name           = "gemfire-locator-${count.index}"
  machine_type   = "${var.locator_machine_type}"
  zone           = "${var.gcp_zone}"
  count          = "${var.locator_count}"

  boot_disk {
    initialize_params {
      image = "${var.image_name}"
    }
  }

  network_interface {
    subnetwork = "${var.subnetwork}"
    address = "${var.locator_private_ips[count.index]}"
  }

  service_account {
    scopes = ["userinfo-email", "compute-ro", "storage-ro"]
  }
}

output "locator_public_ips" {
  value = "${google_compute_instance.gemfire_locator.*.public_ip}"
}