import { useContext } from "react";
import { AppContext } from "../context/AppContext";
import "../style/Home.css";
import { LiaUnlockSolid } from "react-icons/lia";
import { GoArrowUp } from "react-icons/go";
import { HiArrowTrendingUp } from "react-icons/hi2";
import { Link } from "react-router-dom";
import { IoArrowForwardCircleSharp } from "react-icons/io5";
import { AiOutlineThunderbolt } from "react-icons/ai";

const Home = () => {
    const context = useContext(AppContext);

    if (!context) {
        console.error("AppContext is null. Make sure the provider is wrapping the component.");
        return <div>Loading...</div>;  // Prevents crash
    }

    const { basename } = context;

    return (
        <div className="home-page">
            <div className="home-top">
                <div className="home-top-content">
                    <div className="home-top-content-text">
                        <h1>Calorific...</h1>
                    </div>
                    <div className="home-top-content-card">
                        <p>
                            <span className="home-top-content-card-icon"><HiArrowTrendingUp/></span>
                            <span>track your every step with us.</span>
                        </p>
                        <p>
                            <span className="home-top-content-card-icon"><GoArrowUp/></span>
                            <span>level-up your gains now.</span>
                        </p>
                        <p>
                            <span className="home-top-content-card-icon">
                                <LiaUnlockSolid className="home-top-content-card-icon-lock"/>
                            </span>
                            <span>unlock your full potential.</span>
                        </p>
                    </div>
                </div>
            </div>
            <div className="home-bottom">
                <div className="home-bottom-boxes">
                    <div className="home-bottom-box2">
                        <AiOutlineThunderbolt />
                        <h1>calorific has the largest library of exercises to choose from to keep you healthy and the world better.</h1>
                    </div>
                    <div className="home-bottom-box3">
                        <h1>Start your journey now!</h1>
                        <Link className="register-button" to="/register">
                            Register
                            <IoArrowForwardCircleSharp />
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Home;
