import 'package:flutter/material.dart';
import 'package:task_1/Screens/Screen2.dart';
import 'package:task_1/Utils/Essentials.dart';

class Screen1 extends StatefulWidget {
  const Screen1({super.key});

  @override
  State<Screen1> createState() => _Screen1State();
}

class _Screen1State extends State<Screen1> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(246, 249, 255, 1),
      appBar: AppBar(
        backgroundColor: Color.fromRGBO(246, 249, 255, 1),
        leading: IconButton(
          onPressed: () => Navigator.pop(context),
          icon: const Icon(Icons.arrow_back, color: Colors.black),
        ),
        title: customText(
          "Leads",
          "Poppins",
          18,
          FontWeight.w500,
          Colors.black,
        ),
        centerTitle: false, // aligns title to left
        toolbarHeight: 50,
      ),
      body: SingleChildScrollView(
        child: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              spacing: 10,
              children: [
                SizedBox(height: 50),
                // Image 1
                Image.asset("assets/picA.png", height: 200, width: 200),
                // Center Text
                customText(
                  "No Leads yet!",
                  "Poppins",
                  20,
                  FontWeight.w500,
                  Colors.black,
                ),
                // small texts
                RichText(
                  text: const TextSpan(
                    text: "Create your first lead & earn upto  ",
                    style: TextStyle(
                      fontSize: 14,
                      fontFamily: "Poppins",
                      fontWeight: FontWeight.w400,
                      color: Color.fromRGBO(40, 40, 40, 0.8),
                    ),
                    children: [
                      TextSpan(
                        text: "₹5,000",
                        style: TextStyle(
                          fontSize: 14,
                          fontFamily: "Poppins",
                          fontWeight: FontWeight.w600,
                          color: Color.fromRGBO(40, 40, 40, 1),
                        ),
                      ),
                    ],
                  ),
                ),
                const SizedBox(height: 5),
                // Button 1
                customButton(
                  customText(
                    "Start Generating Leads",
                    "Poppins",
                    13,
                    FontWeight.w500,
                    Colors.white,
                  ),
                  context,
                  40,304
                ),

                Row(
                  children: [
                    Expanded(
                      child: Divider(
                        thickness: 1,
                        color: Color.fromRGBO(0, 0, 0, 0.4),
                      ),
                    ),
                    const SizedBox(width: 8),
                    const Text(
                      "Learn How to Create Leads",
                      style: TextStyle(
                        fontSize: 14,
                        fontFamily: "Poppins",
                        fontWeight: FontWeight.w500,
                        color: Color.fromRGBO(40, 40, 40, 0.9),
                      ),
                    ),
                    const SizedBox(width: 8),
                    Expanded(
                      child: Divider(
                        thickness: 1,
                        color: Color.fromRGBO(0, 0, 0, 0.4),
                      ),
                    ),
                  ],
                ),
                const SizedBox(width: 5),
                Image.asset("assets/picB.png", height: 140, width: 350),
              ],
            ),
          ),
        ),
      ),
      floatingActionButton: IconButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => const Screen2()),
          );
        },
        icon: const Icon(Icons.forward, color: Colors.black, size: 30),
      ),
    );
  }
}
