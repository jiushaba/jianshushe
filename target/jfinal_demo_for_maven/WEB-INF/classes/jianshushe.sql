/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : jianshushe

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-05 13:16:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_one
-- ----------------------------
DROP TABLE IF EXISTS `sys_one`;
CREATE TABLE `sys_one` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_one
-- ----------------------------
INSERT INTO `sys_one` VALUES ('1', '本机IP', '33', '/query');
INSERT INTO `sys_one` VALUES ('2', 'http模拟查询', '7', '/httpquery');
INSERT INTO `sys_one` VALUES ('3', 'IP归属地查询', '4', '/ipaddressquery');
INSERT INTO `sys_one` VALUES ('4', '域名Alexa查询', '3', '/yumingquery');
INSERT INTO `sys_one` VALUES ('5', '手机归属地查询', '3', '/phonequery');
INSERT INTO `sys_one` VALUES ('6', '历史上的今天', '3', '/todayquery');
INSERT INTO `sys_one` VALUES ('7', '在线调色板', '1', '/front/color');
INSERT INTO `sys_one` VALUES ('8', 'RGB转16进制', '1', '/front/hex');
INSERT INTO `sys_one` VALUES ('9', 'px转rem', '1', '/front/rem');
INSERT INTO `sys_one` VALUES ('10', '在线MarkDown', '1', '/front/markdown');
INSERT INTO `sys_one` VALUES ('11', 'json生成实体', '1', '/entity/json');
INSERT INTO `sys_one` VALUES ('12', 'xml生成实体', '1', '/entity/xml');
INSERT INTO `sys_one` VALUES ('13', '字符串生成实体', '0', '/entity/string');
INSERT INTO `sys_one` VALUES ('14', 'Url编码解码', '1', '/encode/url');
INSERT INTO `sys_one` VALUES ('15', 'Html编码解码', '1', '/encode/html');
INSERT INTO `sys_one` VALUES ('16', 'ASCII编码解码', '1', '/encode/ascii');
INSERT INTO `sys_one` VALUES ('17', 'Utf-8编码解码', '1', '/encode/utf8');
INSERT INTO `sys_one` VALUES ('18', 'Unicode编码解码', '1', '/encode/unicode');
INSERT INTO `sys_one` VALUES ('19', 'MD5加密', '0', '/encrypt/md5');
INSERT INTO `sys_one` VALUES ('20', 'Base64加密解密', '0', '/encrypt/base64');
INSERT INTO `sys_one` VALUES ('21', '图片转Base64', '0', '/encrypt/image64');
INSERT INTO `sys_one` VALUES ('22', '文件转MD5', '0', '/encrypt/filemd5');
INSERT INTO `sys_one` VALUES ('23', '全角半角转换', '1', '/transfer/dbc');
INSERT INTO `sys_one` VALUES ('24', '大小写转换', '1', '/transfer/upper');
INSERT INTO `sys_one` VALUES ('25', 'Unix时间戳', '1', '/transfer/unix');
INSERT INTO `sys_one` VALUES ('26', '计算字符长度', '1', '/transfer/len');
INSERT INTO `sys_one` VALUES ('27', '生成GUID', '1', '/transfer/guid');
INSERT INTO `sys_one` VALUES ('28', 'URL参数格式化', '1', '/transfer/url');
INSERT INTO `sys_one` VALUES ('29', '进制转换', '1', '/unit/binary');
INSERT INTO `sys_one` VALUES ('30', '时间转换', '1', '/unit/time');
INSERT INTO `sys_one` VALUES ('31', 'js压缩格式化', '1', '/format/js');
INSERT INTO `sys_one` VALUES ('32', 'html压缩格式化', '1', '/format/html');
INSERT INTO `sys_one` VALUES ('33', 'css压缩格式化', '1', '/format/css');
INSERT INTO `sys_one` VALUES ('34', 'json压缩格式化', '1', '/format/json');
INSERT INTO `sys_one` VALUES ('35', 'xml压缩格式化', '1', '/format/xml');
INSERT INTO `sys_one` VALUES ('36', 'sql压缩格式化', '1', '/format/sql');
INSERT INTO `sys_one` VALUES ('37', '正则在线测试', '1', '/regex/test');
INSERT INTO `sys_one` VALUES ('38', '二维码生成', '1', '/ercode/create');
INSERT INTO `sys_one` VALUES ('39', '条形码生成', '1', '/barcode/create');
INSERT INTO `sys_one` VALUES ('40', 'Http状态码', '1', '/docs/http');
INSERT INTO `sys_one` VALUES ('41', 'Content-Type', '1', '/docs/contenttype');
INSERT INTO `sys_one` VALUES ('42', 'Html转义符', '0', '/docs/html');
INSERT INTO `sys_one` VALUES ('43', 'ASCII码表', '0', '/docs/ascii');
INSERT INTO `sys_one` VALUES ('44', '常用正则参考', '2', '/regex/docs');
