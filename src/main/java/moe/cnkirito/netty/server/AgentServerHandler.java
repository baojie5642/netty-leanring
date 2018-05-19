package moe.cnkirito.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import moe.cnkirito.netty.model.AgentRequest;
import moe.cnkirito.netty.model.AgentResponse;

import java.nio.charset.Charset;

/**
 * @author 徐靖峰[OF2938]
 * company qianmi.com
 * Date 2018-05-17
 */
public class AgentServerHandler extends SimpleChannelInboundHandler<AgentRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AgentRequest agentRequest) throws Exception {
        Object result =  invoke();
        AgentResponse agentResponse = new AgentResponse();
        agentResponse.setValue(new String((byte[]) result, Charset.forName("utf-8")));
        agentResponse.setId(agentRequest.getId());
        ctx.writeAndFlush(agentResponse);
    }

    private Object invoke(){
        return "123".getBytes(Charset.forName("utf-8"));
    }


}
