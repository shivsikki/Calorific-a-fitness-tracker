import { createContext, useState } from "react";

export const AppContext = createContext(null);

export const AppContextProvider = ({ children }) => {
    const [basename, setBasename] = useState("HomePage");

    console.log("AppContextProvider is rendering with basename:", basename);

    return (
        <AppContext.Provider value={{ basename, setBasename }}>
            {children}
        </AppContext.Provider>
    );
};
