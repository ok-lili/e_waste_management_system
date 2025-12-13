import React, { useState } from "react";

const SignUp = () => {
    const [name, setName] = useState("");
    const [department, setDepartment] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [roomNumber, setRoomNumber] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const handleSignup = (e) => {
        e.preventDefault();

        if (password !== confirmPassword) {
            alert("Passwords do not match!");
            return;
        }

        alert("Signup Successful!");
    };

    return (
        <div className="min-h-screen flex flex-col items-center justify-center bg-gray-100">

            <div className="bg-white shadow-md p-6 rounded-lg w-80">

                <form className="text-2xl font-semibold text-center mb-4" onSubmit={handleSignup}>
                    <h2>Sign Up</h2>

                    <input
                        type="text"
                        placeholder="Enter full name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <input
                        type="text"
                        placeholder="Enter department"
                        value={department}
                        onChange={(e) => setDepartment(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <input
                        type="number"
                        placeholder="Enter phone number"
                        value={phoneNumber}
                        onChange={(e) => setPhoneNumber(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <input
                        type="number"
                        placeholder="Enter room number"
                        value={roomNumber}
                        onChange={(e) => setRoomNumber(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <input
                        type="email"
                        placeholder="Enter email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <input
                        type="password"
                        placeholder="Enter password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <input
                        type="password"
                        placeholder="Confirm password"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        className="w-full p-2 mb-3 border rounded"

                    />

                    <button type="submit" className=" bg-red-500  px-3 py-1 border rounded text-white">
                        Create Account
                    </button>
                </form>

            </div>

        </div>
    );
};

export default SignUp;
