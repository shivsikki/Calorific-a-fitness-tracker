import { AppContextProvider } from "./context/AppContext";
import Home from "./pages/Home";
import LoginPage from "./pages/LoginPage";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import AddNewWorkout from "./pages/AddNewWorkout";

function App() {
    return (
        <AppContextProvider>
            <Home />
            <Register />
            <LoginPage />
            <Dashboard />
            <AddNewWorkout />
        </AppContextProvider>
    );
}

export default App;
