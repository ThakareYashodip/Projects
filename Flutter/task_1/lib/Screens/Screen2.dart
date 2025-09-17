import 'package:flutter/material.dart';
import 'package:task_1/Screens/Screen3.dart';
import 'package:task_1/Utils/CustomCard.dart';
import 'package:task_1/Utils/Essentials.dart';

import '../Utils/GradientText.dart';

class Screen2 extends StatefulWidget {
  const Screen2({super.key});

  static const List<Map<String, dynamic>> statuses = [
    {"label": "Actionable", "count": 3},
    {"label": "Pending", "count": 2},
    {"label": "Rejected", "count": 1},
    {"label": "Activated", "count": 0},
  ];

  @override
  State<Screen2> createState() => _Screen2State();
}

class _Screen2State extends State<Screen2> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
        backgroundColor: const Color.fromRGBO(246, 249, 255, 1),
        appBar: AppBar(
          backgroundColor: const Color.fromRGBO(246, 249, 255, 1),
          elevation: 0,
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
          centerTitle: false,
          toolbarHeight: 50,
          actions: [
            GestureDetector(
              onTap: () => Navigator.push(
                context,
                MaterialPageRoute(builder: (_) => Screen3()),
              ),
              child: customText(
                "Lead Guide",
                "Poppins",
                14,
                FontWeight.w500,
                const Color.fromRGBO(0, 87, 216, 1),
              ),
            ),
            const SizedBox(width: 4),
            const Icon(
              Icons.play_circle_fill,
              color: Color.fromRGBO(0, 78, 196, 1),
              size: 18,
            ),
            const SizedBox(width: 10),
          ],
        ),
        body: Column(
          children: [
            // Searchbar
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Container(
                height: 40,
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(8),
                  border: Border.all(color: Colors.grey.shade300),
                ),
                child: const TextField(
                  decoration: InputDecoration(
                    hintText: "Search By Name",
                    prefixIcon: Icon(Icons.search),
                    border: InputBorder.none,
                    contentPadding: EdgeInsets.only(top: 8, bottom: 8),
                  ),
                ),
              ),
            ),

            // Tabbar
            const TabBar(
              labelColor: Colors.black,
              // isScrollable: true,
              indicatorSize: TabBarIndicatorSize.tab,
              indicatorColor: Color.fromRGBO(0, 87, 216, 1),
              unselectedLabelStyle: TextStyle(
                fontSize: 14,
                fontFamily: "Poppins",
                fontWeight: FontWeight.w300,
                color: Color.fromARGB(255, 78, 78, 78),
              ),
              tabs: [
                Tab(text: "Credit Cards"),
                Tab(text: "Saving A/C"),
                Tab(text: "Demat A/C"),
              ],
            ),

            // Tab Views
            Expanded(
              child: TabBarView(
                children: [
                  SingleChildScrollView(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        SizedBox(
                          height: 50,
                          child: ListView.builder(
                            scrollDirection: Axis.horizontal,
                            itemCount: Screen2.statuses.length,
                            itemBuilder: (context, index) {
                              final item = Screen2.statuses[index];
                              return Container(
                                margin: const EdgeInsets.symmetric(
                                  horizontal: 6,
                                  vertical: 8,
                                ),
                                padding: const EdgeInsets.symmetric(
                                  horizontal: 14,
                                  vertical: 6,
                                ),
                                decoration: BoxDecoration(
                                  color: Colors.blue.shade50,
                                  borderRadius: BorderRadius.circular(20),
                                ),
                                child: Row(
                                  children: [
                                    Text(
                                      "${item["label"]} (${item["count"]})",
                                      style: const TextStyle(
                                        fontSize: 14,
                                        fontWeight: FontWeight.w500,
                                        color: Colors.blue,
                                      ),
                                    ),
                                  ],
                                ),
                              );
                            },
                          ),
                        ),
                        //
                        CustomCard(isEnable: true, name: "Sarish Patil"),
                        CustomCard(isEnable: true, name: "Ajay Potdar"),
                        CustomCard(isEnable: false, name: "Akshata Kenjale"),
                        CustomCard(isEnable: false, name: "Ninganna"),
                      ],
                    ),
                  ),

                  const Center(child: Text("🔥 Saving A/C Tab Content")),
                  const Center(child: Text("✅ Demat A/C Tab Content")),
                ],
              ),
            ),
          ],
        ),
        bottomNavigationBar: Container(
          padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
          height: 60,
          color: Colors.white,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              customText(
                "Facing an issue? Tap for help.",
                "Poppins",
                14,
                FontWeight.w400,
                const Color.fromRGBO(40, 40, 40, 0.8),
              ),
              Container(
                height: 35,
                width: 150,
                decoration: BoxDecoration(
                  color: Color.fromRGBO(51, 51, 51, 1),
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Center(
                  child: customText(
                    "Need Help",
                    "Inter",
                    14,
                    FontWeight.w500,
                    Colors.white,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
