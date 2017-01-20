#version 120

attribute vec4 Position;

mat4 ProjMat = mat4(vec4(1., 0., 0., 0.), vec4(0., 1., 0., 0.), vec4(0., 0., 1., 0.), vec4(0., 0., 0., 1.));
uniform vec2 InSize = vec2(1., 1.);
uniform vec2 OutSize = vec2(1., 1.);

varying vec2 texCoord;
varying vec2 oneTexel;

void main(){
    vec4 outPos = ProjMat * vec4(Position.xy, 0.0, 1.0);
    gl_Position = vec4(outPos.xy, 0.2, 1.0);

    oneTexel = 1.0 / InSize;

    texCoord = Position.xy / OutSize;
    texCoord.y = 1.0 - texCoord.y;
}
