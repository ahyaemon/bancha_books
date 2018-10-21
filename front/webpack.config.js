const path = require('path')
const { VueLoaderPlugin } = require('vue-loader')
const ExtractTextPlugin = require('extract-text-webpack-plugin')

module.exports = [
  /**
   * vue
   */
  {
    mode: "development",
    entry: './src/index.ts',
    output: {
      path: path.resolve(__dirname, '../src/main/resources/static/js'),
      filename: 'base.js'
    },
    module: {
      rules: [
        {
          test: /\.vue$/,
          exclude: /node_modules/,
          loader: 'vue-loader'
        },
        {
          test: /\.js$/,
          exclude: /node_modules/,
          use: {
            loader: 'babel-loader',
            options: {
              cacheDirectory: true
            }
          },
        },
        {
          test: /\.css$/,
          exclude: /node_modules/,
          use: ['style-loader', 'css-loader']
        },
        {
          test: /\.ts$/,
          exclude: /node_modules/,
          loader: 'ts-loader',
          options: {
            appendTsSuffixTo: [/\.vue$/]
          }
        },
        {
          test: /\.scss$/,
          exclude: /node_modules/,
          use: ["style-loader", "css-loader", "sass-loader"]
        }
      ]
    },
    resolve: {
      extensions: ['.js', '.ts', '.vue'],
      alias: {
        vue$: 'vue/dist/vue.esm.js',
      },
    },
    plugins: [
      new VueLoaderPlugin(),
    ],
    cache: true,
    externals: {
      vue: "Vue",
      animejs: "anime",
      $: "jquery",
    },
  },
  /**
   * scss
   */
  {
	  context: path.join(__dirname, './src/scss'),
	  entry: {
	    base: "./index.scss",
	  },
    output: {
      path: path.join(__dirname, '../src/main/resources/static/css'),
      filename: '[name].css'
    },
    module: {
      rules: [
        {
          test: /\.scss$/,
          use: ExtractTextPlugin.extract({
            fallback: 'style-loader',
            use: ['css-loader', 'sass-loader']
          })
        }
      ]
    },
    plugins: [
      new ExtractTextPlugin('[name].css')
    ]
  }
]