import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:urbanserve/controller/bottom_navbar.dart';
import 'package:urbanserve/screens/complaint_register_screen.dart';
import 'package:urbanserve/screens/home_screen.dart';
import 'package:urbanserve/screens/profile_screen.dart';

class MainScreen extends StatelessWidget {
  MainScreen({super.key});

  final BottomNavController navController = Get.put(BottomNavController());

  final List<Widget> _screens = [
    HomeScreen(),
    ComplaintRegisterScreen(),
    ProfileScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Obx(
      () => Scaffold(
        backgroundColor: Colors.white,
        body: _screens[navController.currentIndex.value],
        bottomNavigationBar: BottomNavigationBar(
          backgroundColor: Colors.white,
          currentIndex: navController.currentIndex.value,
          onTap: navController.changeIndex,
          selectedItemColor: Colors.blue.shade600,
          unselectedItemColor: Colors.grey,
          items: const [
            BottomNavigationBarItem(icon: Icon(Icons.home), label: "Home"),
            BottomNavigationBarItem(
              icon: Icon(Icons.list),
              label: "Complaints",
            ),
            BottomNavigationBarItem(icon: Icon(Icons.person), label: "Profile"),
          ],
        ),
      ),
    );
  }
}
