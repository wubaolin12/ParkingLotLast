window.onload = function (){
          try{
              //��̬����һ��canvasԪ ������ȡ��2Dcontext����������쳣���ʾ��֧��
              document.createElement("canvas").getContext("2d");
              document.getElementById("support").innerHTML = "";
          }catch(e){
              document.getElementById("support").innerHTML = "";
          }
      };
 
      //��δ� ��Ҫ�ǻ�ȡ����ͷ����Ƶ������ʾ��Video ǩ��
      window.addEventListener("DOMContentLoaded", function () {
          var video = document.getElementById("video");
          var videoObj = { "video": true };
          var errBack = function (error){
                  console.log("Video capture error: " + error.message, error.code);
              };
          //  支持浏览器  谷歌,火狐,360,欧朋
              //navigator.getUserMedia这个写法在Opera中好像是navigator.getUserMedianow
              if (navigator.getUserMedia) {
                  navigator.getUserMedia(videoObj, function (stream) {
                  	//谷歌
                       MediaStreamTrack=typeof stream.stop==='function'?stream:stream.getTracks()[1];
                           video.src=(window.URL).createObjectURL(stream);
                      video.play();
                  }, errBack);
              } else if (navigator.webkitGetUserMedia) {
              	//360
                  navigator.webkitGetUserMedia(videoObj, function (stream) {
                      MediaStreamTrack=stream.getTracks()[1];
                      video.src=(window.webkitURL).createObjectURL(stream);
                      video.play();
                  }, errBack);
              } else if (navigator.mozGetUserMedia){
              	//火狐
                  navigator.mozGetUserMedia(videoObj, function (stream) {
                          video.src = window.URL.createObjectURL(stream);15715377670
                          video.play();
                  }, errBack);
              }


          
          //��������հ�ť���¼���
          document.getElementById("snap").addEventListener("click",function(){
                  CatchCode();
          });
      }, false);
      //��ʱ��
      //var interval = setInterval(CatchCode, "300");
      //����� ˢ���� ͼ���
      