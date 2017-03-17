var webpack = require('webpack');
var path = require('path');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: {
        'polyfill': './src/polyfill.ts',
        'vendor': './src/vendor.ts',
        'app': './src/main.ts'
    },

    output: {
        path: path.resolve('./dist'),
        filename: 'js/[name].js'
    },

    resolve: {
        extensions: ['.ts', '.js']
    },

    module: {
        rules: [
            {
                test: /\.ts$/,
                loaders: ['awesome-typescript-loader?', 'angular2-template-loader'],
            },
            {
                test: /\.html$/,
                loaders: ['raw-loader']
            }
        ]
    },

    plugins: [
        new webpack.optimize.CommonsChunkPlugin({
            name: ['vendor', 'polyfill']
        }),

        new HtmlWebpackPlugin({
            template: './src/index.html'
        }),

        new webpack.ProvidePlugin({
            $: "jquery/dist/jquery.min.js",
            jQuery: "jquery/dist/jquery.min.js",
            "window.jQuery": "jquery/dist/jquery.min.js"
        }),
    ],

    devServer: {
        contentBase: './src',
        historyApiFallback: true,
        proxy: {
            '/**': 'http://localhost:8080/HelloWorldTomcat'
        },
    }
};