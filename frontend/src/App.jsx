// import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
// import AssetsPage from "../src/pages/AssetsPage";
// import LoginPage from "../src/pages/LoginPage"
// function App() {
//   return (
//     <Router>
//       <Routes>
//         <Route path="/" element={<LoginPage />} />
//         <Route path="/login" element={<LoginPage />} />
//         <Route path="/assets" element={<AssetsPage />} />
//       </Routes>
//     </Router>
//   );
// }

// export default App;


// src/App.jsx
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AssetsPage from "./pages/AssetsPage";

function App() {
  return (
    <Router>
      <Routes>
        {/* Directly render AssetsPage with full CRUD + categories */}
        <Route path="/" element={<AssetsPage />} />
        <Route path="/assets" element={<AssetsPage />} />
      </Routes>
    </Router>
  );
}

export default App;
