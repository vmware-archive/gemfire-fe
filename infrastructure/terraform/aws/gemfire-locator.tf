resource "aws_instance" "gemfire_locator" {

  ami                         = "${var.ami_id}"
  instance_type               = "${var.locator_instance_type}"
  key_name                    = "${var.aws_key_name}"
  subnet_id                   = "${element(var.subnet_ids, count.index)}"
  private_ip                  = "${var.locator_private_ips[count.index]}"
  associate_public_ip_address = true
  vpc_security_group_ids      = "${var.security_group_ids}"
  iam_instance_profile        = "${var.instance_profile_name}"
  availability_zone           = "${element(var.availability_zones, count.index)}"
  count                       = "${var.locator_count}"

  tags = {
    Name = "gemfire-locator-${count.index}"
    Project = "gemfire-fe"
  }

}

output "locator_public_ips" {
  value = "${aws_instance.gemfire_locator.*.public_ip}"
}