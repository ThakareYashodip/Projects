import 'package:get/get.dart';

class LoginController extends GetxController {
  var username = "".obs;
  var password = "".obs;
  var isLoading = false.obs;
  RxString selectedRole = "User".obs;
  var rememberMe = false.obs;


}
