
//fs模块

//引入fs模块
const fs = require('fs');

//创建流读取对象，没有函数作为参数但是有返回值。
const rs= fs.createReadStream(__dirname+'/1.txt');
console.log(__dirname+'1.txt');

//绑定data事件，
rs.on('data',(chunk)=>{
    console.log(chunk);
    console.log(chunk.length);
})

//可选参数
rs.on('end',()=>{
    console.log('读取结束');
})
