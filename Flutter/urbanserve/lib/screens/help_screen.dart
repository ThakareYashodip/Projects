import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';

class HelpPage extends StatelessWidget {
  final List<Map<String, String>> faqs = [
    {
      "question": "How do I register a complaint?",
      "answer":
          "Go to the home screen, tap on 'Register Complaint', and fill in the required details.",
    },
    {
      "question": "Can I edit a complaint after submission?",
      "answer":
          "Currently, you cannot edit complaints. Please contact support for changes.",
    },
    {
      "question": "How do I track my complaint status?",
      "answer":
          "Navigate to the 'Complaints' section from the dashboard to view your complaint statuses.",
    },
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: CustomScrollView(
        slivers: [
          _buildSliverAppBar(),
          SliverToBoxAdapter(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      const Icon(
                        Icons.question_answer_outlined,
                        color: Color(0xFF6366F1),
                        size: 26,
                      ),
                      const SizedBox(width: 10),
                      Text(
                        "Frequently Asked Questions",
                        style: GoogleFonts.poppins(
                          fontSize: 22,
                          fontWeight: FontWeight.w700,
                          foreground: Paint()
                            ..shader = const LinearGradient(
                              colors: [
                                Color(0xFF6366F1), // Indigo
                                Color(0xFF8B5CF6), // Purple
                              ],
                            ).createShader(const Rect.fromLTWH(0, 0, 200, 70)),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 12),
                  ...faqs.map((faq) => _buildFaqTile(faq)),
                  const SizedBox(height: 24),
                  Divider(thickness: 1, color: Colors.grey.shade300),
                  const SizedBox(height: 12),
                  Row(
                    children: [
                      const Icon(
                        Icons.support_agent,
                        color: Color(0xFF10B981),
                        size: 26,
                      ),
                      const SizedBox(width: 10),
                      Text(
                        "Contact Support",
                        style: GoogleFonts.poppins(
                          fontSize: 22,
                          fontWeight: FontWeight.w700,
                          color: const Color(0xFF10B981), // Emerald
                          shadows: [
                            Shadow(
                              blurRadius: 4,
                              color: Colors.black.withOpacity(0.1),
                              offset: const Offset(1, 2),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 12),
                  _buildContactRow(Icons.email, "support@urbanserve.com"),
                  _buildContactRow(Icons.phone, "+91-7666556478"),
                  _buildContactRow(Icons.access_time, "Mon–Fri, 9 AM to 6 PM"),
                  const SizedBox(height: 24),
                  Center(child: _buildhelpButton()),
                  const SizedBox(height: 32),
                  Divider(),
                  Center(
                    child: Text(
                      "UrbanServe v1.0.0",
                      style: TextStyle(color: Colors.grey.shade600),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildFaqTile(Map<String, String> faq) {
    return Card(
      color: const Color.fromARGB(243, 255, 254, 254),
      margin: const EdgeInsets.symmetric(vertical: 6),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: ExpansionTile(
        leading: Icon(Icons.adjust),
        title: Text(
          faq['question']!,
          style: const TextStyle(fontWeight: FontWeight.w600),
        ),
        children: [
          Padding(
            padding: const EdgeInsets.symmetric(
              horizontal: 16.0,
              vertical: 8.0,
            ),
            child: Text(faq['answer']!),
          ),
        ],
      ),
    );
  }

  Widget _buildContactRow(IconData icon, String text) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 4.0),
      child: Row(
        children: [
          Icon(icon, color: Colors.blue.shade600),
          const SizedBox(width: 12),
          Expanded(child: Text(text, style: const TextStyle(fontSize: 16))),
        ],
      ),
    );
  }
}

Widget _buildSliverAppBar() {
  return SliverAppBar(
    expandedHeight: 120,
    floating: true,
    pinned: true,
    automaticallyImplyLeading: false,
    elevation: 0,
    backgroundColor: Colors.transparent,
    flexibleSpace: Container(
      clipBehavior: Clip.antiAlias,
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [Color(0xFF667EEA), Color(0xFF764BA2), Color(0xFF667EEA)],
        ),
      ),
      child: FlexibleSpaceBar(
        title: Text(
          "Help",
          style: GoogleFonts.inter(
            color: Colors.white,
            fontSize: 24,
            fontWeight: FontWeight.w700,
            letterSpacing: -0.5,
          ),
        ),
        centerTitle: false,
        titlePadding: const EdgeInsets.only(left: 20, bottom: 16),
      ),
    ),
    actions: [
      Container(
        margin: const EdgeInsets.only(right: 16),
        child: IconButton(
          onPressed: () {},
          icon: Container(
            padding: const EdgeInsets.all(8),
            decoration: BoxDecoration(
              color: Colors.white.withOpacity(0.2),
              borderRadius: BorderRadius.circular(12),
            ),
            child: const Icon(
              Icons.notifications_outlined,
              color: Colors.white,
              size: 22,
            ),
          ),
        ),
      ),
    ],
  );
}

Widget _buildhelpButton() {
  return Container(
    width: double.infinity,
    height: 56,
    decoration: BoxDecoration(
      gradient: const LinearGradient(
        begin: Alignment.topLeft,
        end: Alignment.bottomRight,
        colors: [Color(0xFF4F46E5), Color.fromARGB(255, 74, 66, 232)],
      ),
      borderRadius: BorderRadius.circular(16),
      boxShadow: [
        BoxShadow(
          color: const Color(0xFF4F46E5).withOpacity(0.4),
          blurRadius: 20,
          offset: const Offset(0, 8),
        ),
      ],
    ),
    child: ElevatedButton.icon(
      onPressed: () {
        Get.snackbar(
          "🔔 Support",
          "Opening contact form...",
          backgroundColor: Colors.white,
          colorText: Colors.black,
          snackPosition: SnackPosition.BOTTOM,
          margin: const EdgeInsets.all(12),
          borderRadius: 12,
          icon: const Icon(Icons.support_agent, color: Colors.blueAccent),
        );
      },
      icon: const Icon(Icons.support_agent_rounded, color: Colors.white),
      label: Text(
        "Need Help? Contact Support",
        style: GoogleFonts.inter(
          color: Colors.white,
          fontSize: 16,
          fontWeight: FontWeight.w600,
        ),
      ),
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.transparent,
        shadowColor: Colors.transparent,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      ),
    ),
  );
}
