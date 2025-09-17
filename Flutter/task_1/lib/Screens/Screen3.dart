import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:task_1/Utils/CustomCard.dart';
import 'package:task_1/Utils/Essentials.dart';
import 'package:task_1/Utils/GradientText.dart';

class Screen3 extends StatefulWidget {
  const Screen3({super.key});

  static const List<Map<String, dynamic>> list = [
    {"label": "All"},
    {"label": "Actionable"},
    {"label": "Pending"},
    {"label": "Rejected"},
    {"label": "Activated"},
  ];

  static const steps = [
    {"title": "Card Activated", "subtitle": "", "status": "pending"},
    {"title": "Card Dispatched", "subtitle": "", "status": "pending"},
    {"title": "Approval Status", "subtitle": "", "status": "pending"},
    {
      "title": "Application Under Review",
      "subtitle": "Customer Acceptance Pending",
      "status": "review",
    },
    {
      "title": "Accept Terms & Conditions",
      "subtitle": "12 June 2025, 10:15 AM",
      "status": "done",
    },
    {
      "title": "Eligibility Check",
      "subtitle": "07 June 2025, 3 PM",
      "status": "done",
    },
    {
      "title": "Income Proof Submission",
      "subtitle": "05 June 2025, 12 PM",
      "status": "done",
    },
    {
      "title": "KYC & Verification",
      "subtitle": "03 June 2025, 11 AM",
      "status": "done",
    },
    {
      "title": "Fill Application Form",
      "subtitle": "02 June 2025, 10 AM",
      "status": "done",
    },
    {
      "title": "Application Started",
      "subtitle": "01 June 2025, 9:30 AM",
      "status": "done",
    },
  ];

  @override
  State<Screen3> createState() => _Screen3State();
}

class _Screen3State extends State<Screen3> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 2,
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
            "Akshata Kenjale",
            "Poppins",
            18,
            FontWeight.w500,
            Colors.black,
          ),
          centerTitle: false,
          toolbarHeight: 50,
          actions: const [
            FaIcon(FontAwesomeIcons.whatsapp, color: Colors.green, size: 30),
            SizedBox(width: 10),
          ],
        ),

        body: Column(
          children: [
            const TabBar(
              labelColor: Colors.black,
              indicatorSize: TabBarIndicatorSize.tab,
              indicatorColor: Color.fromRGBO(0, 87, 216, 1),
              unselectedLabelStyle: TextStyle(
                fontSize: 14,
                fontFamily: "Poppins",
                fontWeight: FontWeight.w300,
                color: Color.fromARGB(255, 78, 78, 78),
              ),
              tabs: [
                Tab(
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Text(
                        "Credit Cards",
                        style: TextStyle(
                          fontSize: 14,
                          fontWeight: FontWeight.w500,
                          color: Colors.black,
                        ),
                      ),
                      SizedBox(width: 6),
                      CircleAvatar(
                        radius: 10,
                        backgroundColor: Colors.red,
                        child: Text(
                          "5",
                          style: TextStyle(fontSize: 12, color: Colors.white),
                        ),
                      ),
                    ],
                  ),
                ),
                Tab(
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Text(
                        "Recommended for You",
                        style: TextStyle(
                          fontSize: 14,
                          fontWeight: FontWeight.w500,
                          color: Colors.black,
                        ),
                      ),
                      SizedBox(width: 6),
                      CircleAvatar(
                        radius: 10,
                        backgroundColor: Colors.red,
                        child: Text(
                          "5",
                          style: TextStyle(fontSize: 12, color: Colors.white),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),

            Expanded(
              child: TabBarView(
                children: [
                  SingleChildScrollView(
                    child: Column(
                      children: [
                        const SizedBox(height: 10),
                        SizedBox(
                          height: 50,
                          child: ListView.builder(
                            scrollDirection: Axis.horizontal,
                            itemCount: Screen3.list.length,
                            itemBuilder: (context, index) {
                              final item = Screen3.list[index];
                              return Container(
                                margin: const EdgeInsets.symmetric(
                                  horizontal: 6,
                                ),
                                padding: const EdgeInsets.symmetric(
                                  horizontal: 14,
                                  vertical: 6,
                                ),
                                decoration: BoxDecoration(
                                  color: Colors.blue.shade50,
                                  borderRadius: BorderRadius.circular(20),
                                ),
                                child: Center(
                                  child: Text(
                                    "${item["label"]}",
                                    style: const TextStyle(
                                      fontSize: 14,
                                      fontWeight: FontWeight.w500,
                                      color: Colors.blue,
                                    ),
                                  ),
                                ),
                              );
                            },
                          ),
                        ),
                        const SizedBox(height: 10),

                        // C-1
                        Container(
                          width: 360,
                          padding: const EdgeInsets.symmetric(
                            horizontal: 18,
                            vertical: 8,
                          ),
                          decoration: BoxDecoration(
                            color: Colors.white,
                            borderRadius: BorderRadius.circular(16),
                          ),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              customText(
                                "LIC Axis Bank Credit Card",
                                "Poppins",
                                16,
                                FontWeight.w500,
                                Colors.black,
                              ),
                              RichText(
                                text: TextSpan(
                                  children: [
                                    WidgetSpan(
                                      child: GradientText(
                                        "Earning Opportunity: Rs. 5,530  ",
                                        style: const TextStyle(
                                          fontSize: 11,
                                          fontFamily: "Poppins",
                                          fontWeight: FontWeight.w500,
                                        ),
                                        gradient: const LinearGradient(
                                          colors: [
                                            Color(0xFFC6951A),
                                            Color(0xFFFFEC9E),
                                            Color(0xFFC6951A),
                                          ],
                                          stops: [0.0, 0.5, 1.0],
                                        ),
                                      ),
                                    ),
                                    const TextSpan(
                                      text: "|  Sold: 5 Services so far",
                                      style: TextStyle(
                                        fontSize: 11,
                                        fontFamily: "Poppins",
                                        fontWeight: FontWeight.w600,
                                        color: Color.fromRGBO(40, 40, 40, 0.8),
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                              const SizedBox(height: 12),
                              Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  customText(
                                    "APPLICATION STATUS",
                                    "Poppins",
                                    12,
                                    FontWeight.w500,
                                    Colors.black54,
                                  ),
                                  customText(
                                    "Hide Details 👁️",
                                    "Poppins",
                                    12,
                                    FontWeight.w500,
                                    Color.fromRGBO(0, 87, 216, 1),
                                  ),
                                ],
                              ),
                              ListView.builder(
                                shrinkWrap: true,
                                physics: const NeverScrollableScrollPhysics(),
                                itemCount: Screen3.steps.length,
                                itemBuilder: (context, index) {
                                  final step = Screen3.steps[index];
                                  final isLast =
                                      index == Screen3.steps.length - 1;

                                  return Row(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    children: [
                                      Column(
                                        children: [
                                          customStatusIcon(step["status"]!),
                                          if (!isLast)
                                            Container(
                                              width: 2,
                                              height: 50,
                                              color: Colors.grey.shade300,
                                            ),
                                        ],
                                      ),
                                      const SizedBox(width: 12),
                                      Expanded(
                                        child: Column(
                                          crossAxisAlignment:
                                              CrossAxisAlignment.start,
                                          children: [
                                            Text(
                                              step["title"]!,
                                              style: const TextStyle(
                                                fontSize: 15,
                                                fontWeight: FontWeight.w600,
                                              ),
                                            ),
                                            if (step["subtitle"]!.isNotEmpty)
                                              Padding(
                                                padding:
                                                    const EdgeInsets.symmetric(
                                                      vertical: 4,
                                                    ),
                                                child: Text(
                                                  step["subtitle"]!,
                                                  style: TextStyle(
                                                    fontSize: 13,
                                                    color: Colors.grey.shade600,
                                                  ),
                                                ),
                                              ),
                                          ],
                                        ),
                                      ),
                                    ],
                                  );
                                },
                              ),
                            ],
                          ),
                        ),

                        const SizedBox(height: 20),

                        //C-2
                        Container(
                          height: 240,
                          width: 360,
                          padding: EdgeInsets.all(12),
                          decoration: BoxDecoration(
                            color: Colors.white,
                            borderRadius: BorderRadius.circular(8),
                          ),
                          child: Column(
                            spacing: 5,
                            mainAxisAlignment: MainAxisAlignment.start,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              customText(
                                "LIC Axis Bank Credit Card",
                                "Poppins",
                                16,
                                FontWeight.w500,
                                Colors.black,
                              ),
                              RichText(
                                text: TextSpan(
                                  children: [
                                    WidgetSpan(
                                      child: GradientText(
                                        "Earning Opportunity: Rs. 5,530  ",
                                        style: const TextStyle(
                                          fontSize: 11,
                                          fontFamily: "Poppins",
                                          fontWeight: FontWeight.w500,
                                        ),
                                        gradient: const LinearGradient(
                                          begin: Alignment.centerLeft,
                                          end: Alignment.centerRight,
                                          colors: [
                                            Color(0xFFC6951A),
                                            Color(0xFFFFEC9E),
                                            Color(0xFFC6951A),
                                          ],
                                          stops: [0.0, 0.5, 1.0],
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                              Center(
                                child: Container(
                                  height: 100,
                                  width: 336,
                                  padding: EdgeInsets.symmetric(
                                    horizontal: 25,
                                    vertical: 20,
                                  ),
                                  decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(16),
                                    color: Color.fromRGBO(255, 249, 242, 1),
                                  ),
                                  child: Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    children: [
                                      customText(
                                        "Customer Action Required",
                                        "Poppins",
                                        12,
                                        FontWeight.w500,
                                        Colors.black,
                                      ),
                                      customText(
                                        "Upload income proof to proceed with your application",
                                        "Poppins",
                                        12,
                                        FontWeight.w400,
                                        const Color.fromRGBO(0, 0, 0, 0.7),
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              customButton3(
                                customText(
                                  "Complete Form",
                                  "Poppins",
                                  12,
                                  FontWeight.w400,
                                  Colors.white,
                                ),
                                context,
                                Color.fromRGBO(0, 87, 216, 1),
                              ),
                              Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  customText(
                                    "APPLICATION STATUS",
                                    "Poppins",
                                    12,
                                    FontWeight.w500,
                                    Colors.black54,
                                  ),
                                  customText(
                                    "Hide Details 👁️",
                                    "Poppins",
                                    12,
                                    FontWeight.w500,
                                    Color.fromRGBO(0, 87, 216, 1),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                        const SizedBox(height: 20),

                        Image.asset("assets/pic3.png", height: 512),
                      ],
                    ),
                  ),
                  const Center(child: Text("🔥 Recommended Tab Content")),
                ],
              ),
            ),
          ],
        ),

        bottomNavigationBar: Container(
          padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
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
                  color: const Color.fromRGBO(51, 51, 51, 1),
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
