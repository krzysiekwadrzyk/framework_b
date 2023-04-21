package config;

public enum DriveFactory {

    CHROME {
        @Override
        public DriverManager getDriverManager() {

            return new ChromeDriverManager();

        }
    },

    FIREFOX {
        @Override
        public DriverManager getDriverManager() {

            return new FirefoxDriverManager();

        }
    };

    public abstract DriverManager getDriverManager();

}
