//call hogi authService yha

import React, { useState } from "react";
import { Link } from "react-router-dom";
import AuthService from "../api/AuthService";
import {useNavigate} from "react-router-dom";


const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

   const navigate = useNavigate();

  const handleLogin = async(e) => {
    e.preventDefault();
    try {
        const response = await AuthService.login(email,password);
        navigate("/assets");
    } catch (error) {
        alert("invalid credentials");
    }
  };

  return (
    <>
      <div className="min-h-screen flex flex-col items-center justify-center bg-gray-100">
        <div className="bg-white shadow-md p-6 rounded-lg w-80">
          <h2 className="text-2xl font-semibold text-center mb-4">Login</h2>

          <form onSubmit={handleLogin}>
            <input
              type="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
              className="w-full p-2 mb-3 border rounded"
            />

            <input
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              className="w-full p-2 mb-3 border rounded"
            />

            <button
              type="submit"
              className="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700"
            >
              Login
            </button>
          </form>

          <p className="mt-4 text-center">
            Don’t have an account?{" "}
            <Link to="/signup" className="text-blue-600 hover:underline">
              Sign up
            </Link>
          </p>
        </div>
      </div>
    </>
  );
};

export default LoginPage;
