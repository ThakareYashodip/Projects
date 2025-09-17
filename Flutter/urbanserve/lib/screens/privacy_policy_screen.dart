import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class PrivacyPolicyPage extends StatelessWidget {
  final List<Map<String, String>> policies = [
    {
      "title": "Data Collection",
      "description":
          "We collect minimal data necessary to provide our services, including your name, contact information, and complaint details.",
    },
    {
      "title": "Data Usage",
      "description":
          "Your data is used solely for resolving complaints, improving our services, and ensuring system security.",
    },
    {
      "title": "Third-party Sharing",
      "description":
          "We do not share your personal data with third parties without your consent, unless required by law.",
    },
    {
      "title": "Data Retention",
      "description":
          "We retain your data for as long as necessary to fulfill the purposes outlined in this policy.",
    },
    {
      "title": "Your Rights",
      "description":
          "You can request to view, update, or delete your data by contacting support.",
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
                        Icons.privacy_tip_outlined,
                        color: Color(0xFF6366F1),
                        size: 26,
                      ),
                      const SizedBox(width: 10),
                      Text(
                        "Privacy Policy",
                        style: GoogleFonts.poppins(
                          fontSize: 22,
                          fontWeight: FontWeight.w700,
                          foreground: Paint()
                            ..shader = const LinearGradient(
                              colors: [Color(0xFF6366F1), Color(0xFF8B5CF6)],
                            ).createShader(const Rect.fromLTWH(0, 0, 200, 70)),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 16),
                  ...policies.map((policy) => _buildPolicyTile(policy)),
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

  Widget _buildPolicyTile(Map<String, String> policy) {
    return Card(
      color: const Color.fromARGB(243, 255, 254, 254),
      margin: const EdgeInsets.symmetric(vertical: 8),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: ExpansionTile(
        leading: const Icon(Icons.security_outlined),
        title: Text(
          policy['title']!,
          style: const TextStyle(fontWeight: FontWeight.w600),
        ),
        children: [
          Padding(
            padding: const EdgeInsets.symmetric(
              horizontal: 16.0,
              vertical: 8.0,
            ),
            child: Text(
              policy['description']!,
              style: const TextStyle(fontSize: 15, height: 1.4),
            ),
          ),
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
      decoration: const BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [Color(0xFF667EEA), Color(0xFF764BA2), Color(0xFF667EEA)],
        ),
      ),
      child: FlexibleSpaceBar(
        title: Text(
          "UrbanServe",
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
              Icons.info_outline,
              color: Colors.white,
              size: 22,
            ),
          ),
        ),
      ),
    ],
  );
}
