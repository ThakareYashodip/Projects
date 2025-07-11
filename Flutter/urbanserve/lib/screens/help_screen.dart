import 'package:flutter/material.dart';
import 'package:get/get.dart';

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
      appBar: AppBar(
        title: const Text("Help & Support"),
        backgroundColor: Colors.blue.shade600,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "Frequently Asked Questions",
              style: Theme.of(context).textTheme.titleLarge,
            ),
            const SizedBox(height: 12),
            ...faqs.map((faq) => _buildFaqTile(faq)),
            const SizedBox(height: 24),
            Divider(thickness: 1, color: Colors.grey.shade300),
            const SizedBox(height: 12),
            Text(
              "Contact Support",
              style: Theme.of(context).textTheme.titleLarge,
            ),
            const SizedBox(height: 12),
            _buildContactRow(Icons.email, "support@urbanserve.com"),
            _buildContactRow(Icons.phone, "+91-9876543210"),
            _buildContactRow(Icons.access_time, "Mon–Fri, 9 AM to 6 PM"),
            const SizedBox(height: 24),
            ElevatedButton.icon(
              onPressed: () {
                // Navigate to support request form or mail
                Get.snackbar("Support", "Support request form will open.");
              },
              icon: const Icon(Icons.support_agent),
              label: const Text("Still need help? Contact Us"),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.blue.shade700,
                minimumSize: const Size(double.infinity, 50),
              ),
            ),
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
    );
  }

  Widget _buildFaqTile(Map<String, String> faq) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 6),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: ExpansionTile(
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
