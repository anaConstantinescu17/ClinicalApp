var path = require("path");

module.exports = {
  entry: "./src/main/js/app.js",
  devtool: "sourcemaps",
  cache: true,
  mode: "development",

  output: {
    path: path.join(__dirname, 'src/main/resources/static/built/'),
    filename: 'bundle.js',
    publicPath: '/built/',
  },
  devServer: {
    contentBase: [path.join(__dirname, 'src/main/resources/templates'), path.join(__dirname, 'src/main/resources/static')],
    compress: true,
    port: 9000,
  },
  module: {
    rules: [
      {
        test: path.join(__dirname, "."),
        exclude: /(node_modules)/,
        use: [
          {
            loader: "babel-loader",
            options: {
              presets: ["@babel/preset-env", "@babel/preset-react"],
            },
          },
        ],
      },
      {
        test: /\.(woff2?|ttf|svg|eot|png|jpe?g|gif)$/,
        include: [path.resolve(__dirname, "src/main/resources/static/images")],
        use: {
          loader: "file-loader",
          options: { name: "[name]-[contenthash].[ext]" },
        },
      },
    ],
  },
  //   devServer: {
  //     host: "localhost",
  //     port: 8081,
  //     historyApiFallback: true,
  //     open: true,
  //   },
};
