uniform sampler2D bgl_RenderedTexture;
uniform int time; // Passed in, see ShaderHelper.java

float rand(vec2 co) {
   return fract(sin(dot(co.xy, vec2(12.9898,78.233))) * 43758.5453);
}

void main() {
    vec2 texcoord = vec2(gl_TexCoord[0]);
    vec4 color = texture2D(bgl_RenderedTexture, texcoord);
    
    gl_FragColor = vec4(color.r - (rand(time)/10), color.g - (rand(time)/10), color.b - (rand(time)/10), 1);
}