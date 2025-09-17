import React from "react";
import { Navbar, Row, Col, Container, Nav, Button } from "react-bootstrap";

function Header() {
  return (
    <Navbar bg="light" className="shadow-sm">
      <Container fluid>
        <Row className="w-100 align-items-center">
          {/* Left: Logo (2/12 width) */}
          <Col xs={2}>
            <Navbar.Brand>LOGO</Navbar.Brand>
          </Col>

          {/* Middle: Nav Links (8/12 width) */}
          <Col xs={8}>
            <Nav className="justify-content-center">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="/">Project</Nav.Link>
              <Nav.Link href="/">Contact</Nav.Link>
            </Nav>
          </Col>

          {/* Right: Button (2/12 width) */}
          <Col xs={2} className="text-end">
            <Button variant="primary">Login</Button>
          </Col>
        </Row>
      </Container>
    </Navbar>
  );
}

export default Header;
