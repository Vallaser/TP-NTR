module.exports = {
  root: true,
  env: {
    browser: true,
    node: true,
  },
  'extends': [
    'plugin:vue/essential',
    'plugin:vue/recommended',
    '@vue/standard',
    'standard',
    'plugin:promise/recommended'
  ],
  // required to lint *.vue files
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    // allow debugger during development
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',

    // allow paren-less arrow functions
    'arrow-parens': 0,
    // allow async-await
    'generator-star-spacing': 0,
    // Needed to evaluate expressions
    'no-new-func': 0,
    // Not an actual standard
    'space-before-function-paren': 0,
    // Our keyboards can easily type both " and '
    'quotes': 0,
    // 2 spaces indentation
    "indent": ["error", 2],
    "no-template-curly-in-string": 0,
    'standard/no-callback-literal': 0,
    "capitalized-comments": [
      "error",
      "always",
      {
        "ignoreInlineComments": true,
        "ignoreConsecutiveComments": true
      }
    ],
    "vue/attribute-hyphenation": ["error", "never"],
    "vue/name-property-casing": 0, "vue/order-in-components": ["error", {
      "order": [
        "el",
        "name",
        "parent",
        "functional",
        ["delimiters", "comments"],
        ["components", "directives", "filters"],
        "extends",
        "mixins",
        "inheritAttrs",
        "model",
        ["props", "propsData"],
        "fetch",
        "asyncData",
        "data",
        "computed",
        "watch",
        "methods",
        "LIFECYCLE_HOOKS",
        "head",
        ["template", "render"],
        "renderError"
      ]
    }],
    "semi": ["error", "always"],
    'promise/always-return': 1,
    'promise/no-callback-in-promise': 1,
    'promise/prefer-await-to-then': 1
  },
  parserOptions: {
    parser: 'babel-eslint',
    sourceType: 'module'
  },
  overrides: [
    {
      files: [
        '**/__tests__/*.{j,t}s?(x)'
      ],
      env: {
        mocha: true
      }
    }
  ]
}
