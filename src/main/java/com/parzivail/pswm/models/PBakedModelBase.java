package com.parzivail.pswm.models;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.annotation.Nullable;
import javax.vecmath.Vector4f;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Colby on 1/30/2017.
 */
public class PBakedModelBase implements IBakedModel
{
	private final PModelBase pModelBase;
	private final IModelState state;
	private final VertexFormat format;
	private final Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter;

	public PBakedModelBase(PModelBase pModelBase, IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
	{
		this.pModelBase = pModelBase;
		this.state = state;
		this.format = format;
		this.bakedTextureGetter = bakedTextureGetter;
	}

	@Override
	public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand)
	{
		ArrayList<BakedQuad> quads = new ArrayList<>();
		for (ModelRenderer r : pModelBase.model.boxList)
		{
			for (ModelBox b : r.cubeList)
			{
				// front
				quads.add(buildQuad(format, Optional.absent(), side, bakedTextureGetter.apply(pModelBase.texture), 0xFFFFFF, b.posX1, b.posY1, b.posZ1, 0, 0, b.posX2, b.posY1, b.posZ1, 0, 0, b.posX2, b.posY2, b.posZ1, 0, 0, b.posX1, b.posY2, b.posZ1, 0, 0));

				// back
				quads.add(buildQuad(format, Optional.absent(), side, bakedTextureGetter.apply(pModelBase.texture), 0xFFFFFF, b.posX1, b.posY1, b.posZ2, 0, 0, b.posX2, b.posY1, b.posZ2, 0, 0, b.posX2, b.posY2, b.posZ2, 0, 0, b.posX1, b.posY2, b.posZ2, 0, 0));

				//left
				quads.add(buildQuad(format, Optional.absent(), side, bakedTextureGetter.apply(pModelBase.texture), 0xFFFFFF, b.posX1, b.posY1, b.posZ1, 0, 0, b.posX1, b.posY2, b.posZ1, 0, 0, b.posX1, b.posY2, b.posZ2, 0, 0, b.posX1, b.posY1, b.posZ2, 0, 0));

				// right
				quads.add(buildQuad(format, Optional.absent(), side, bakedTextureGetter.apply(pModelBase.texture), 0xFFFFFF, b.posX2, b.posY1, b.posZ1, 0, 0, b.posX2, b.posY2, b.posZ1, 0, 0, b.posX2, b.posY2, b.posZ2, 0, 0, b.posX2, b.posY1, b.posZ2, 0, 0));

				// top
				quads.add(buildQuad(format, Optional.absent(), side, bakedTextureGetter.apply(pModelBase.texture), 0xFFFFFF, b.posX1, b.posY2, b.posZ1, 0, 0, b.posX2, b.posY2, b.posZ1, 0, 0, b.posX2, b.posY2, b.posZ2, 0, 0, b.posX1, b.posY2, b.posZ2, 0, 0));

				// bottom
				quads.add(buildQuad(format, Optional.absent(), side, bakedTextureGetter.apply(pModelBase.texture), 0xFFFFFF, b.posX1, b.posY1, b.posZ1, 0, 0, b.posX2, b.posY1, b.posZ1, 0, 0, b.posX2, b.posY1, b.posZ2, 0, 0, b.posX1, b.posY1, b.posZ2, 0, 0));
			}
		}
		return null;
	}

	@Override
	public boolean isAmbientOcclusion()
	{
		return false;
	}

	@Override
	public boolean isGui3d()
	{
		return true;
	}

	@Override
	public boolean isBuiltInRenderer()
	{
		return false;
	}

	@Override
	public TextureAtlasSprite getParticleTexture()
	{
		return null;
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms()
	{
		return null;
	}

	@Override
	public ItemOverrideList getOverrides()
	{
		return null;
	}

	private static final BakedQuad buildQuad(VertexFormat format, Optional<TRSRTransformation> transform, EnumFacing side, TextureAtlasSprite sprite, int tint, float x0, float y0, float z0, float u0, float v0, float x1, float y1, float z1, float u1, float v1, float x2, float y2, float z2, float u2, float v2, float x3, float y3, float z3, float u3, float v3)
	{
		UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(format);
		builder.setQuadTint(tint);
		builder.setQuadOrientation(side);
		builder.setTexture(sprite);
		putVertex(builder, format, transform, side, x0, y0, z0, u0, v0);
		putVertex(builder, format, transform, side, x1, y1, z1, u1, v1);
		putVertex(builder, format, transform, side, x2, y2, z2, u2, v2);
		putVertex(builder, format, transform, side, x3, y3, z3, u3, v3);
		return builder.build();
	}

	private static void putVertex(UnpackedBakedQuad.Builder builder, VertexFormat format, Optional<TRSRTransformation> transform, EnumFacing side, float x, float y, float z, float u, float v)
	{
		Vector4f vec = new Vector4f();
		for (int e = 0; e < format.getElementCount(); e++)
		{
			switch (format.getElement(e).getUsage())
			{
				case POSITION:
					if (transform.isPresent())
					{
						vec.x = x;
						vec.y = y;
						vec.z = z;
						vec.w = 1;
						transform.get().getMatrix().transform(vec);
						builder.put(e, vec.x, vec.y, vec.z, vec.w);
					}
					else
					{
						builder.put(e, x, y, z, 1);
					}
					break;
				case COLOR:
					builder.put(e, 1f, 1f, 1f, 1f);
					break;
				case UV:
					if (format.getElement(e).getIndex() == 0)
					{
						builder.put(e, u, v, 0f, 1f);
						break;
					}
				case NORMAL:
					builder.put(e, (float)side.getFrontOffsetX(), (float)side.getFrontOffsetY(), (float)side.getFrontOffsetZ(), 0f);
					break;
				default:
					builder.put(e);
					break;
			}
		}
	}
}
