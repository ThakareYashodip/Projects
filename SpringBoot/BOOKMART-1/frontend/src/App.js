import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  // Function that returns JSX
  function myapp() {
    return (
      <button onClick={() => alert("Button inside myapp pressed!")}>
        Press me
      </button>
    );
  }

  function apps() {
    return <h1>Yash</h1>;
  }

  return (
    <div style={{ textAlign: "start", marginTop: "50px" ,marginLeft: "18px1"}}>
      <h1>Hello React 👋</h1>
      <p>You clicked {count} times</p>

      {/* Counter button */}
      <button onClick={() => setCount(count + 1)}>Click Me</button>

      {/* Render function JSX */}
      <div style={{ marginTop: "20px" }}>{myapp()}</div>

      {/* Render apps function */}
      <div>{apps()}</div>
    </div>
  );
}

export default App;
